package io.github.enbool.dict.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

/**
 * @author luoshi@sensetime.com
 * @description 用户上下文
 * @date 2020/8/22 18:13
 */
@Setter
public class UserContextHolder {
    public static TransmittableThreadLocal<UserContext> userContextThreadLocal = new TransmittableThreadLocal<>();

    private UserContextHolder() {}

    public static boolean isEmpty() {
        UserContext userContext = userContextThreadLocal.get();
        if (null == userContext || userContext.getUserId() == null) {
            return true;
        }
        return false;
    }

    public static UserContext getContext() {
        UserContext userContext = userContextThreadLocal.get();
        if (null == userContext) {
            userContextThreadLocal.set(new UserContext());
        }
        return userContextThreadLocal.get();
    }

    public static UserContext init(HttpServletRequest httpServletRequest) {
        userContextThreadLocal.set(new UserContext(httpServletRequest));
        return userContextThreadLocal.get();
    }

    public static void clear() {
        userContextThreadLocal.remove();
    }

    public static Long getUserId() {
        return getContext().getUserId();
    }
    public static String getUserName() {
        return getContext().getUsername();
    }

    public static String getRequestFrom() {
        return getContext().getRequestFrom();
    }
}
