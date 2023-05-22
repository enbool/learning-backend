package io.github.enbool.dict.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 11:30
 */
@Data
@NoArgsConstructor
@Schema(description = "AccessToken Object")
public class AccessToken {
    @Schema(description = "token")
    private String token;
    @Schema(description = "过期时间")
    private Long expireAt;

    public AccessToken(String token, Long expireAt) {
        this.token = token;
        this.expireAt = expireAt;
    }
}
