package io.github.enbool.dict.integration;

import io.github.enbool.dict.model.entity.Actor;

/**
 * @Description: 语音引擎
 * @Author: wumin2
 * @Date: 2023/4/28 11:21
 */
public interface VoiceEngine {

    /**
     * 语音合成
     *
     * @param text
     * @param actor 讲述人
     * @return
     */
    byte[] synthesis(String text, Actor actor);
}
