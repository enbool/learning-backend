package io.github.enbool.dict.model.enums;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 17:59
 */
public enum UserType {
    ADMIN("ADMIN", "管理员"),
    USER("USER", "普通用户");

    private String code;

    private String description;

    UserType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
