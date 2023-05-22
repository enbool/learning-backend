package io.github.enbool.dict.controller;

import cn.hutool.core.io.file.FileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.enbool.dict.integration.VoiceService;
import io.github.enbool.dict.model.ElevenActorType;
import io.github.enbool.dict.model.WordJson;
import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.repository.ActorRepository;
import io.github.enbool.dict.service.DictionaryService;
import io.github.enbool.dict.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 16:57
 */
@RestController("/api/app")
public class AppController {
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private WordService wordService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private VoiceService voiceService;
    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/voice")
    public String voice(@RequestParam String text, @RequestParam String actorName) {
        UserContextHolder.getContext().setUserId(1L);
        ElevenActorType actorType = ElevenActorType.getByName(actorName);
        Actor actor = new Actor();
        actor.setVoiceId(actorType.getVoiceId());
        return voiceService.synthesis(text, actor);
    }

    //@PostMapping("/save")
    public Long saveDict(@RequestParam String path, @RequestParam String dictName, @RequestParam String dictDesc) throws JsonProcessingException {
        // 1、根据path读取文件
        FileReader fileReader = new FileReader(path);
        // 2、读取文件的内容
        String content = fileReader.readString();
        // 3、解析文件，生成word对象
        List<WordJson> wordJsons = objectMapper.readValue(content, new TypeReference<List<WordJson>>() {
        });
        Dictionary dictionary = new Dictionary();
        dictionary.setName(dictName);
        dictionary.setDescription(dictDesc);
        Long dictionaryId = dictionaryService.save(dictionary);
        List<Word> words = wordJsons.stream()
                .map(wordJson -> {
                    Word word = new Word();
                    word.setDictionaryId(dictionaryId);
                    word.setName(wordJson.getName());
                    //word.setTranslate(wordJson.getTrans());
                    word.setUs(wordJson.getUsphone());
                    word.setUk(wordJson.getUkphone());
                    return word;
                })
                .collect(Collectors.toList());

        // 4、保存word对象
        wordService.saveAll(words);

        return (long) words.size();
    }

    //@PostMapping("/youDao")
    public void youDao(@RequestParam String path) throws JsonProcessingException {
        File root = new File(path);
        File[] files = root.listFiles();
        for (File file : files) {
            String name = file.getName();
            String dictName = name.substring(0, name.lastIndexOf("."));
            String dictDesc = "";
            processOneFile(file.getAbsolutePath(), dictName, dictDesc);
        }
    }

    //@GetMapping("/test")
    public void updateNumber() {
        List<Dictionary> dictionaries = dictionaryService.listAll();
        // 计算每个字典的单词数量
        for (Dictionary dictionary : dictionaries) {
            Long dictionaryId = dictionary.getId();
            Long count = wordService.countByDictionaryId(dictionaryId);
            dictionary.setNumber(Math.toIntExact(count));
            dictionaryService.save(dictionary);
        }
    }

    private long processOneFile(String path, String dictName, String dictDesc) throws JsonProcessingException {
        // 1、根据path读取文件
        FileReader fileReader = new FileReader(path);

        Dictionary dictionary = new Dictionary();
        dictionary.setName(dictName);
        dictionary.setDescription(dictDesc);
        Long dictionaryId = dictionaryService.save(dictionary);
        // 2、读取文件的内容
        List<String> contents = fileReader.readLines();
        List<Word> words = new ArrayList<>(contents.size());
        Set<String> names = new HashSet<>(contents.size());
        for (String content : contents) {
            System.out.println(content);
            Word word = new Word();
            word.setDictionaryId(dictionaryId);
            JsonNode jsonNode = objectMapper.readTree(content);
            Integer wordRank = jsonNode.findValue("wordRank").asInt();
            word.setRank(wordRank);
            String headWord = jsonNode.findValue("headWord").asText();
            if (names.contains(headWord)) {
                continue;
            } else {
                names.add(headWord);
            }
            word.setName(headWord);
            JsonNode content1 = jsonNode.findValue("content");
            JsonNode wordStr = content1.findValue("word");
            JsonNode content2 = wordStr.findValue("content");
            String realContent = content2.toString();
            word.setContent(realContent);
            words.add(word);
        }

        wordService.saveAll(words);

        return words.size();
    }
}
