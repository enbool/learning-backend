package io.github.enbool.dict.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.enbool.dict.constants.PageCons;
import io.github.enbool.dict.utils.AntiSQLFilter;
import io.github.enbool.dict.utils.TypeUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Author enbool
 * @create 2020/1/9 19:22
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    protected <T> Page<T> getPage() {
        return this.getPage(false);
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
            orderItems.addAll(OrderItem.ascs(getParameterSafeValues(PageCons.PAGE_ASCS)));
            orderItems.addAll(OrderItem.descs(getParameterSafeValues(PageCons.PAGE_DESCS)));
            page.setOrders(orderItems);
        }
        return page;
    }

    protected String[] getParameterSafeValues(String parameter) {
        return AntiSQLFilter.getSafeValues(this.request.getParameterValues(parameter));
    }
}
