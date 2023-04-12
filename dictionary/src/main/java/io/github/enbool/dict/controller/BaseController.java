package io.github.enbool.dict.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.enbool.dict.constants.PageCons;
import io.github.enbool.dict.utils.AntiSQLFilter;
import io.github.enbool.dict.utils.StringUtil;
import io.github.enbool.dict.utils.TypeUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.StringPool.COMMA;


/**
 * @Author enbool
 * @create 2020/1/9 19:22
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    protected <T> Page<T> getPage() {
        return this.getPage(true);
    }

    protected <T> Page<T> getPage(boolean openSort) {
        int index = 1;
        // 页数
        Integer cursor = TypeUtils.castToInt(request.getParameter(PageCons.PAGE_PAGE), index);
        // 分页大小
        Integer limit = TypeUtils.castToInt(request.getParameter(PageCons.PAGE_ROWS), PageCons.DEFAULT_LIMIT);
        Boolean searchCount = TypeUtils.castToBoolean(request.getParameter(PageCons.SEARCH_COUNT), true);
        limit = limit > PageCons.MAX_LIMIT ? PageCons.MAX_LIMIT : limit;

        Page<T> page = new Page<>(cursor, limit, searchCount);
        // 排序
        if (openSort) {
            List<OrderItem> orderItems = new ArrayList<>(8);
            String[] ascs = getParameterSafeValues(PageCons.PAGE_ASC);
            if (ascs != null && ascs.length > 0) {
                orderItems.addAll(OrderItem.ascs(ascs));
            }
            String[] descs = getParameterSafeValues(PageCons.PAGE_DESC);
            if (descs != null && descs.length > 0) {
                orderItems.addAll(OrderItem.descs(descs));
            }
            page.setOrders(orderItems);
        }
        return page;
    }

    protected String[] getParameterSafeValues(String parameter) {
        String value = this.request.getParameter(parameter);
        if (StringUtil.isBlank(value)) {
            return null;
        }
        return AntiSQLFilter.getSafeValues(value.split(COMMA));
    }
}
