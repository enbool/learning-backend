package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.mapper.WordMapper;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.model.vo.WordVO;
import io.github.enbool.dict.repository.WordRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:31
 */
@Component
public class WordRepositoryImpl extends ServiceImpl<WordMapper, Word> implements WordRepository {


    @Override
    public Long countByDictionaryId(Long dictionaryId) {
        return this.lambdaQuery()
                .eq(Word::getDictionaryId, dictionaryId)
                .count();
    }

    @Override
    public IPage<WordVO> pageByDictionary(Long dictionaryId, Page<Word> page) {
        this.lambdaQuery()
                .eq(Word::getDictionaryId, dictionaryId)
                .page(page);

        return page.convert(WordVO::new);
    }

    @Override
    public List<WordVO> queryByName(String name) {
        LambdaQueryChainWrapper<Word> lambdaQueryChainWrapper = this.lambdaQuery().select(Word::getId, Word::getName, Word::getContent);

        /**
         * 如果单词长度大于3，那么就模糊查询
         */
        if (name.length() > 3) {
            lambdaQueryChainWrapper.likeRight(Word::getName, name);
        } else {
            lambdaQueryChainWrapper.eq(Word::getName, name);
        }
        return lambdaQueryChainWrapper
                .list()
                .stream()
                .distinct()
                .map(WordVO::new)
                .toList();
    }
}
