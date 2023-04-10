package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.mapper.DictionaryMapper;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.repository.DictionaryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:32
 */
@Component
public class DictionaryRepositoryImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryRepository {

}
