package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.mapper.DictionaryMapper;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.query.DictionaryQuery;
import io.github.enbool.dict.repository.DictionaryRepository;
import io.github.enbool.dict.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:32
 */
@Component
public class DictionaryRepositoryImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryRepository {

    @Override
    public List<Dictionary> list(DictionaryQuery query) {
        return this.lambdaQuery()
                .like(StringUtils.isNotBlank(query.getName()), Dictionary::getName, query.getName())
                .eq(StringUtils.isNotBlank(query.getAuthor()), Dictionary::getAuthor, query.getAuthor())
                .list();
    }
}
