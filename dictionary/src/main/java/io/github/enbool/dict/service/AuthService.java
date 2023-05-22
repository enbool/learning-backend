package io.github.enbool.dict.service;

import io.github.enbool.dict.model.dto.AccessToken;
import io.github.enbool.dict.model.form.UsernamePasswordForm;

/**
 * @Description: Auth Service
 * @Author: wumin2
 * @Date: 2023/5/22 10:55
 */
public interface AuthService {
    /**
     * 登录
     *
     * @param form 用户名和密码
     *
     * @return token
     */
    AccessToken loginByUsername(UsernamePasswordForm form);
}
