package io.github.enbool.dict.model.enums;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 17:59
 */
public enum GenderEnum {
    UNKNOWN("UNKNOWN", "未知"),
    MALE("MALE", "男"),
    FEMALE("FEMALE", "女");

    private String code;

    private String description;

    GenderEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
