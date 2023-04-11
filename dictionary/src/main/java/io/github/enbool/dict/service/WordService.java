package io.github.enbool.dict.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.model.form.WordForm;
import io.github.enbool.dict.model.vo.WordVO;

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

    /**
     * 分页查询
     * @param page 分页对象
     * @param dictionaryId 字典id
     * @return 分页结果
     */
    IPage<WordVO> pageByDictionary(Long dictionaryId, Page<Word> page);

    /**
     * update word
     * @param form
     * @return
     */
    Boolean update(WordForm form);

    /**
     * 根据id删除单词
     * @param id 单词id
     * @return 是否删除成功
     */
    Boolean removeById(Long id);
}
