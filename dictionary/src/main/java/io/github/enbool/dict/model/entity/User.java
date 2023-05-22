package io.github.enbool.dict.model.entity;

import io.github.enbool.dict.model.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
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
@Getter
@Setter
@Schema(name = "User", description = "用户表")
public class User extends BaseEntity implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String avatar;

    private String nickname;

    private Boolean enabled;

    private UserType userType;

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
}
