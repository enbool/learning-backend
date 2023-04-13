package io.github.enbool.dict.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.model.form.WordForm;
import io.github.enbool.dict.model.vo.WordVO;
import io.github.enbool.dict.repository.WordRepository;
import io.github.enbool.dict.service.WordService;
import io.github.enbool.dict.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:42
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public void saveAll(List<Word> words) {
        wordRepository.saveBatch(words);
    }

    @Override
    public Long countByDictionaryId(Long dictionaryId) {
        return wordRepository.countByDictionaryId(dictionaryId);
    }

    @Override
    public IPage<WordVO> pageByDictionary(Long dictionaryId, Page<Word> page) {
        AssertUtils.notNull(dictionaryId, BusinessErrorEnum.PARAM_INVALID_ERROR);
        return wordRepository.pageByDictionary(dictionaryId, page);
    }

    @Override
    public Boolean update(WordForm form) {
        Word word = form.convert();
        return wordRepository.updateById(word);
    }

    @Override
    public Boolean removeById(Long id) {
        return wordRepository.removeById(id);
    }

    @Override
    public List<WordVO> queryByName(String name) {
        return wordRepository.queryByName(name);
    }
}
