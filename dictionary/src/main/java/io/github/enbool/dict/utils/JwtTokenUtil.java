package io.github.enbool.dict.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/19 18:46
 */
@Slf4j
public class JwtTokenUtil {
    /**
     * token的头key
     */
    public static final String TOKEN_HEADER = "Authorization";
    /**
     * token前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";


    /**
     * 加密的key
     */
    public static final String APP_SECRET_KEY = "SUZ3ZWYyMzRTMkY7RUZTRjtaVixNRUlPUFAtUjIzLFNPUFBQU0RGO10yMz1HUlRZW04uL0JLQVBbTDM0LU9HLEVQQUxUNDMtRSxPRVJULUFTS0wzUFtFV1RPTC1bMzQ1VExbNUtzZGZrLTM0LHJob2dvOztkZmc7cm1sO2NpMGVyOw==";

    /**
     * 权限的声明key
     */
    private static final String ROLE_CLAIM = "role";

    public static final String USERNAME_CLAIM = "username";

    /**
     * 生成token
     *
     * @param user 用户
     * @param issueAt 签发时间
     * @param expiration 过期时间
     *
     * @return token
     */
    public static String createToken(UserDetails user, Long issueAt, Long expiration) {
        String token = Jwts
                .builder()
                .setSubject(user.getUsername())
                .claim(ROLE_CLAIM, user.getAuthorities())
                .claim(USERNAME_CLAIM, user.getUsername())
                .setIssuedAt(new Date(issueAt))
                .setExpiration(new Date(issueAt + expiration))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET_KEY)
                .compact();

        return token;
    }

    /**
     * 获取当前登录用户用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.get(USERNAME_CLAIM).toString();
    }

    /**
     * 获取当前登录用户角色
     *
     * @param token
     * @return
     */
    public static String getUserRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET_KEY)
                .parseClaimsJws(token).getBody();
        return claims.get(ROLE_CLAIM).toString();
    }


    /**
     * 检查token是否过期
     *
     * @param token token
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration()
                .before(new Date());
    }


    public static boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public static String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(APP_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
