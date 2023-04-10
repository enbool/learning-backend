package io.github.enbool.dict.context;

import io.github.enbool.dict.utils.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
     * 请求来源
     */
    public static final String HTTP_HEADER_REQUEST_FROM_KEY = "requestFrom";

    /**
     * 用户ID
     */
    public static final String HTTP_HEADER_USER_ID_KEY = "userId";

    /**
     * 用户名
     */
    public static final String HTTP_HEADER_USER_NAME_KEY = "username";

    /**
     * 请求ulr
     */
    public static final String HTTP_HEADER_REQ_URL_KEY = "reqUrl";

    /**
     * ip
     */
    public static final String HTTP_HEADER_IP_KEY = "ip";

    /**
     * 国际化语言
     */
    public static final String HTTP_HEADER_LANG_KEY = "lang";

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账户名称
     */
    private String username;

    /**
     * 国际化使用语言
     */
    private String lang = "en-US";

    /**
     * 请求来源
     */
    private String requestFrom;

    /**
     * 请求接口地址
     */
    private String reqUrl;

    /**
     * 请求地址ip
     */
    private String ip;


    public UserContext(HttpServletRequest httpServletRequest) {
        String userIdStr = httpServletRequest.getHeader(HTTP_HEADER_USER_ID_KEY);
        this.userId = Long.valueOf(userIdStr);
        String username = httpServletRequest.getHeader(HTTP_HEADER_USER_NAME_KEY);
        if (StringUtil.isNotBlank(username)) {
            //解析用户账号（中文名会出现乱码问题）
            try {
                this.username = URLDecoder.decode(username, "UTF-8");
            } catch (UnsupportedEncodingException e) {

            }
        }
        this.lang = httpServletRequest.getHeader(HTTP_HEADER_LANG_KEY);
        this.requestFrom = httpServletRequest.getHeader(HTTP_HEADER_REQUEST_FROM_KEY);
        this.reqUrl = httpServletRequest.getHeader(HTTP_HEADER_REQ_URL_KEY);
        this.ip = httpServletRequest.getHeader(HTTP_HEADER_IP_KEY);
    }

}
