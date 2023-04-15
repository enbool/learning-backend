package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.WordPlan;
import io.github.enbool.dict.mapper.WordPlanMapper;
import io.github.enbool.dict.repository.WordPlanRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单词计划 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Service
public class WordPlanRepositoryImpl extends ServiceImpl<WordPlanMapper, WordPlan> implements WordPlanRepository {

}
