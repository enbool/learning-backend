package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.enbool.dict.model.enums.GenderEnum;
import io.github.enbool.dict.model.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 17:55
 */
@Setter
@TableName(value = "user")
@Schema(name = "User", description = "用户表")
public class User extends BaseEntity implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "性别")
    private GenderEnum gender = GenderEnum.UNKNOWN;
    @Schema(description = "是否启用")
    private Boolean enabled = false;
    @Schema(description = "用户类型")
    private UserType userType = UserType.USER;
    @Schema(description = "用户信息")
    private String userInfo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserInfo() {
        return userInfo;
    }
}
