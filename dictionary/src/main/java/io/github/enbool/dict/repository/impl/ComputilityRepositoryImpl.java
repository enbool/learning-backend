package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Computility;
import io.github.enbool.dict.mapper.ComputilityMapper;
import io.github.enbool.dict.repository.ComputilityRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 算力值 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ComputilityRepositoryImpl extends ServiceImpl<ComputilityMapper, Computility> implements ComputilityRepository {

}
