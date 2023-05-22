package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 10:52
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            User user = new User();
            user.setId(1L);
            user.setUsername("admin");
            return user;
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}
