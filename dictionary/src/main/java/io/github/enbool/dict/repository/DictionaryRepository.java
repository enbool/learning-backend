package io.github.enbool.dict.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.query.DictionaryQuery;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:29
 */
public interface DictionaryRepository extends IService<Dictionary> {
    /**
     * list dictionary by query
     * @param query criteria of dictionary
     * @return
     */
    List<Dictionary> list(DictionaryQuery query);
}
