package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.model.dto.AccessToken;
import io.github.enbool.dict.model.form.UsernamePasswordForm;
import io.github.enbool.dict.service.AuthService;
import io.github.enbool.dict.utils.AssertUtils;
import io.github.enbool.dict.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static io.github.enbool.dict.constants.ProjectConstants.ADMIN_EXPIRATION;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 11:26
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccessToken loginByUsername(UsernamePasswordForm form) {
        // 1、校验用户名密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(form.getUsername());
        AssertUtils.notNull(userDetails, BusinessErrorEnum.TOKEN_ERROR);
        AssertUtils.isTrue(passwordEncoder.matches(form.getPassword(), userDetails.getPassword()), BusinessErrorEnum.TOKEN_ERROR);
        // 2、生成token
        Long now = Instant.now().toEpochMilli();
        String token = JwtTokenUtil.createToken(userDetails, now, ADMIN_EXPIRATION);
        AccessToken accessToken = new AccessToken(token, now + ADMIN_EXPIRATION);

        return accessToken;
    }
}
