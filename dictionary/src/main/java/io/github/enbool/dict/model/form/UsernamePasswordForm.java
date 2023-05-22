package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 11:40
 */
@Data
@Schema(name = "UsernamePasswordForm", description = "UsernamePasswordForm")
public class UsernamePasswordForm {
    @Schema(description = "用户名")
    @NotBlank
    private String username;
    @Schema(description = "密码")
    @NotBlank
    private String password;
}
