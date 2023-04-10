package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.mapper.WordMapper;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.repository.WordRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:31
 */
@Component
public class WordRepositoryImpl extends ServiceImpl<WordMapper, Word> implements WordRepository {

}
