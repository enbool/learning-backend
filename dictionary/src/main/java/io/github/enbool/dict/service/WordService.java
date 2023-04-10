package io.github.enbool.dict.service;

import io.github.enbool.dict.model.entity.Word;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:40
 */
public interface WordService {
    /**
     * 批量保存单词
     * @param words 单词 列表
     */
    void saveAll(List<Word> words);

    /**
     * 根据字典id获取单词数量
     * @param dictionaryId 字典id
     * @return 单词数量
     */
    Long countByDictionaryId(Long dictionaryId);
}
