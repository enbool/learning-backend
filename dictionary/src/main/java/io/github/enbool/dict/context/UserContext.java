package io.github.enbool.dict.context;

import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.exception.BusinessException;
import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.utils.AssertUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static io.github.enbool.dict.constants.ProjectConstants.COLON;

/**
 * @author wumin2
 * @Description: 用户上下文信息
 * @date 2022年08月17日 18:29
 */
@Data
@NoArgsConstructor
@Slf4j
public class UserContext {

    /**
     * By default, SecurityContextHolder uses a ThreadLocal to store these details,
     * which means that the SecurityContext is always available to methods in the same thread,
     * even if the SecurityContext is not explicitly passed around as an argument to those methods.
     * Using a ThreadLocal in this way is quite safe if you take care to clear the thread after the present principal’s request is processed.
     * Spring Security’s FilterChainProxy ensures that the SecurityContext is always cleared.     *
     */


    /**
     * 获取当前登录用户名
     *
     * @return
     */
    public static String getUsernameSafely() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null || !(context.getAuthentication().getPrincipal()  instanceof  User)) {
            return null;
        }
        User principal = (User) context.getAuthentication().getPrincipal();

        return principal.getUsername();
    }

    /**
     * 获取当前登录用户名
     *
     * @return 用户名
     * @throws BusinessException User information exception
     */
    public static String getUsername() {
        String username = getUsernameSafely();
        AssertUtils.notBlank(username, BusinessErrorEnum.USER_INFO_ERROR);

        return username;
    }

    /**
     * 获取当前登录用户ID
     *
     * @return 用户ID
     * @throws BusinessException User information exception
     */
    public static Long getUserId() {
        Long userId = getUserIdSafely();
        AssertUtils.notNull(userId, BusinessErrorEnum.USER_INFO_ERROR);

        return userId;
    }

    /**
     * 获取当前登录用户ID
     *
     * @return
     */
    public static Long getUserIdSafely() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null || !(context.getAuthentication().getPrincipal()  instanceof  User)) {
            return null;
        }
        User principal = (User) context.getAuthentication().getPrincipal();

        return principal.getId();
    }

    /**
     * 获取当前登录用户的ID和用户名
     *
     * @return userId:username
     */
    public static String getUserSafely() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null || !(context.getAuthentication().getPrincipal()  instanceof  User)) {
            return null;
        }
        User principal = (User) context.getAuthentication().getPrincipal();

        return principal.getId() + COLON + principal.getUsername();
    }
}
