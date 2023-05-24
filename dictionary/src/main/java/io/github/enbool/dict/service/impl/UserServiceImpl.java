package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.model.form.UserRegisterForm;
import io.github.enbool.dict.repository.UserRepository;
import io.github.enbool.dict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 10:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long registerAdmin(UserRegisterForm form) {
        return userRepository.registerAdmin(form);
    }
}
