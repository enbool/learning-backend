package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.query.DictionaryQuery;
import io.github.enbool.dict.repository.DictionaryRepository;
import io.github.enbool.dict.repository.WordRepository;
import io.github.enbool.dict.service.DictionaryService;
import io.github.enbool.dict.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.github.enbool.dict.exception.BusinessErrorEnum.DICTIONARY_NOT_EMPTY;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:43
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Autowired
    private WordRepository wordRepository;

    @Override
    public Long save(Dictionary dictionary) {
        dictionaryRepository.saveOrUpdate(dictionary);
        return dictionary.getId();
    }

    @Override
    public List<Dictionary> listAll() {
        return dictionaryRepository.list();
    }

    @Override
    public List<Dictionary> list(DictionaryQuery query) {
        return dictionaryRepository.list(query);
    }

    @Override
    public Boolean delete(Long id) {
        Long wordCount = wordRepository.countByDictionaryId(id);
        AssertUtils.isTrue(wordCount == 0, DICTIONARY_NOT_EMPTY);

        return dictionaryRepository.removeById(id);
    }
}
