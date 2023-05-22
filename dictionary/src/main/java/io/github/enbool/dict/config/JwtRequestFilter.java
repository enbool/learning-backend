package io.github.enbool.dict.config;

import io.github.enbool.dict.utils.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static io.github.enbool.dict.utils.JwtTokenUtil.TOKEN_HEADER;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/19 18:30
 */
@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    public static final String BEARER = "Bearer ";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && JwtTokenUtil.validateJwtToken(jwt)) {
                String username = JwtTokenUtil.getUsernameFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error("无法设置用户认证:{}", e);
        }

        filterChain.doFilter(request, response);
    }

    /**
     * 从请求头中获取token
     *
     * @param request
     * @return
     */
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader(TOKEN_HEADER);

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(BEARER)) {
            return headerAuth.substring(BEARER.length());
        }
        return null;
    }
}
