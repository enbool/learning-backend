package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.WordPlan;
import io.github.enbool.dict.service.WordPlanService;
import io.github.enbool.dict.repository.WordPlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 单词计划 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Service
public class WordPlanServiceImpl  implements WordPlanService{
    @Autowired
    private WordPlanRepository WordPlanRepository;
}
