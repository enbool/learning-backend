package io.github.enbool.dict.integration.impl;

import io.github.enbool.dict.integration.VoiceEngine;
import io.github.enbool.dict.model.ElevenActorType;
import io.github.enbool.dict.model.entity.Actor;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 13:15
 */
@SpringBootTest
class ElevenFreeEngineTest {
    @Resource(name = "elevenFreeEngine")
    private VoiceEngine voiceEngine;

    @Test
    void synthesis() {
        Actor actor = new Actor();
        actor.setVoiceId(ElevenActorType.ANTONI.getVoiceId());
        voiceEngine.synthesis("hello world", actor);
    }
}