package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.repository.WordRepository;
import io.github.enbool.dict.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:42
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public void saveAll(List<Word> words) {
        wordRepository.saveBatch(words);
    }

    @Override
    public Long countByDictionaryId(Long dictionaryId) {

        return wordRepository.lambdaQuery()
                .eq(Word::getDictionaryId, dictionaryId)
                .count();
    }
}
