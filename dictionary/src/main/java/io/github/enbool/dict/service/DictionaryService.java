package io.github.enbool.dict.service;

import io.github.enbool.dict.model.entity.Dictionary;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:43
 */
public interface DictionaryService {
    /**
     * 保存字典
     * @param dictionary 字典
     * @return 保存后的字典
     */
    Long save(Dictionary dictionary);

    /**
     * 获取字典列表
     * @return 字典列表
     */
    List<Dictionary> list();

}
