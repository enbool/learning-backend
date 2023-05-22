package io.github.enbool.dict.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 14:28
 */
@Component
public class DefaultWhiteListService implements WhiteListService {
    private static final String[] whiteList = new String[]{
            "/doc.html",
            "/webjars/",
            "/v3/api-docs",
            "/api/v1/auth/register",
            "/api/v1/auth/username",
            "/api/v1/auth/refresh",
            "/api/v1/user/logout",
            "/api/v1/user/verify",
            "/api/v1/user/verifyCode",
            "/api/v1/user/verifyCode/refresh"};

    @Override
    public boolean permit(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (String s : whiteList) {
            if (uri.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
