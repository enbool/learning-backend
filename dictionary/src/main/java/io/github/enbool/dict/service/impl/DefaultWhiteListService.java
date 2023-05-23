package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.properties.ApplicationProperties;
import io.github.enbool.dict.service.WhiteListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 14:28
 */
@Component
public class DefaultWhiteListService implements WhiteListService {

    @Autowired
    private ApplicationProperties applicationProperties;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public boolean permit(HttpServletRequest request) {
        String uri = request.getRequestURI();
        boolean permit = applicationProperties.getSecurity().getWhitelist()
                .stream()
                .anyMatch(pattern -> pathMatcher.match(pattern, uri));

        return permit;
    }
}
