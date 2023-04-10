package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.repository.DictionaryRepository;
import io.github.enbool.dict.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:43
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public Long save(Dictionary dictionary) {
        dictionaryRepository.saveOrUpdate(dictionary);
        return dictionary.getId();
    }

    @Override
    public List<Dictionary> list() {
        return dictionaryRepository.list();
    }
}
