package io.github.enbool.dict.integration;

import io.github.enbool.dict.context.UserContextHolder;
import io.github.enbool.dict.model.entity.Actor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 15:03
 */
@Service
public class VoiceService {
    @Resource(name = "elevenFreeEngine")
    private VoiceEngine voiceEngine;
    @Resource(name = "qiniuFileService")
    private FileService fileService;


    /**
     * 把输入的文字转换成语音，根据选择的声音类型，返回语音文件的url
     *
     * @param text 输入的文字
     * @param actor 选择的声音类型
     * @return
     */
    public String synthesis(String text, Actor actor) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("synthesis");
        byte[] bytes = voiceEngine.synthesis(text, actor);
        stopWatch.stop();
        stopWatch.start("upload");
        String fileName = fileService.upload(bytes, null, UserContextHolder.getUserId() + actor.getVoiceId() + UUID.randomUUID() + ".wav");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return fileService.getFileUrl(fileName);
    }

}