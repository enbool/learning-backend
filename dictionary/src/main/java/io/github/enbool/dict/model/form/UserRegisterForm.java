package io.github.enbool.dict.model.form;

import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.model.enums.GenderEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/23 11:00
 */
@Data
@Schema(name = "UserRegisterForm", description = "用户注册表单")
public class UserRegisterForm {
    @Schema(description = "用户名")
    @NotBlank
    private String username;
    @Schema(description = "密码")
    @NotBlank
    private String password;
    @NotBlank
    @Schema(description = "邮箱")
    private String email;
    @NotBlank
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "性别")
    private GenderEnum gender = GenderEnum.UNKNOWN;

    public User convert() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setPhone(this.phone);
        user.setAvatar(this.avatar);
        user.setNickname(this.nickname);
        user.setGender(this.gender);

        return user;
    }
}
