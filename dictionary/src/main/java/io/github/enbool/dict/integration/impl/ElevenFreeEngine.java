package io.github.enbool.dict.integration.impl;

import cn.hutool.core.io.FileUtil;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.integration.VoiceEngine;
import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.utils.AssertUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 11:25
 */
@Service("elevenFreeEngine")
public class ElevenFreeEngine implements VoiceEngine {
    private static final String URL = "https://api.elevenlabs.io/v1/text-to-speech/%s/stream";
    private static final String MODEL_ID = "eleven_multilingual_v1";
    private static final Integer TEXT_MAX_LENGTH = 333;

    @Autowired
    private WebClient webClient;

    @Override
    public byte[] synthesis(String text, Actor actor) {
        AssertUtils.isTrue(text.length() <= TEXT_MAX_LENGTH, BusinessErrorEnum.PARAM_INVALID_ERROR, "text length must less than " + TEXT_MAX_LENGTH);
        byte[] voice = webClient.post()
                .uri(String.format(URL, actor.getVoiceId()))
                .bodyValue(new RequestBody(MODEL_ID, text))
                .retrieve()
                .bodyToMono(byte[].class)
                .block();

        return voice;
    }

    @Data
    @NoArgsConstructor
    public static class RequestBody {
        private String modelId;
        private String text;

        public RequestBody(String modelId, String text) {
            this.modelId = modelId;
            this.text = text;
        }
    }

}
