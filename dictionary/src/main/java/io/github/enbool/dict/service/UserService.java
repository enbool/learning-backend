package io.github.enbool.dict.service;

import io.github.enbool.dict.model.form.UserRegisterForm;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 10:52
 */
public interface UserService extends UserDetailsService {

    /**
     * 注册管理员
     *
     * @param form
     * @return
     */
    Long registerAdmin(UserRegisterForm form);
}
