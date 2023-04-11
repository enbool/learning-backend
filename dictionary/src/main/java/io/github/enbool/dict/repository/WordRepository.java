package io.github.enbool.dict.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.model.vo.WordVO;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:28
 */
public interface WordRepository extends IService<Word> {
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
}
