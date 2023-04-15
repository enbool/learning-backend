package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Computility;
import io.github.enbool.dict.service.ComputilityService;
import io.github.enbool.dict.repository.ComputilityRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 算力值 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ComputilityServiceImpl  implements ComputilityService{
    @Autowired
    private ComputilityRepository ComputilityRepository;
}
