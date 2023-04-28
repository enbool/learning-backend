package io.github.enbool.dict.model;

import lombok.Getter;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 12:54
 */
@Getter
public enum ElevenActorType {

    RACHEL("Rachel", "21m00Tcm4TlvDq8ikWAM", "美式英语女声"),
    DOMI("Domi", "AZnzlk1XvdvUeBnXmlld", "美式英语女声"),
    BELLA("Bella", "EXAVITQu4vr4xnSDxMaL", "美式英语女声"),
    ANTONI("Antoni", "ErXwobaYiN019PkySvjV", "美式英语男声"),
    Elli("Elli", "MF3mGyEYCl7XYWbV9V6O", "美式英语女声"),
    JOSH("Josh", "TxGEqnHWrfWFTfGW9XjX", "美式英语男声"),
    ARNOLD("Arnold", "VR6AewLTigWG4xSOukaG", "美式英语男声"),
    ADAM("Adam", "pNInz6obpgDQGcFmaJgB", "美式英语男声"),
    SAM("Sam", "yoZ06aMxZJJ28mfd3POQ", "美式英语男声"),
    ;
    private String name;

    private String voiceId;
    private String description;

    ElevenActorType(String name, String voiceId, String description) {
        this.name = name;
        this.voiceId = voiceId;
        this.description = description;
    }

    /**
     * 根据名称获取枚举
     * @param name
     * @return
     */
    public static ElevenActorType getByName(String name) {
        for (ElevenActorType value : values()) {
            if (value.name.equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
