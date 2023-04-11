package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.mapper.DictionaryMapper;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.query.DictionaryQuery;
import io.github.enbool.dict.repository.DictionaryRepository;
import io.github.enbool.dict.utils.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
                .like(StringUtil.isNotBlank(query.getName()), Dictionary::getName, query.getName())
                .eq(StringUtil.isNotBlank(query.getAuthor()), Dictionary::getAuthor, query.getAuthor())
                .list();
    }
}
