package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.NewWord;
import io.github.enbool.dict.mapper.NewWordMapper;
import io.github.enbool.dict.repository.NewWordRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 生词本 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class NewWordRepositoryImpl extends ServiceImpl<NewWordMapper, NewWord> implements NewWordRepository {

}
