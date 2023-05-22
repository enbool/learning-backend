package io.github.enbool.dict.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 14:26
 */
public interface WhiteListService {
    /**
     * 请求是否放行
     * @param request
     * @return
     */
    boolean permit(HttpServletRequest request);
}
