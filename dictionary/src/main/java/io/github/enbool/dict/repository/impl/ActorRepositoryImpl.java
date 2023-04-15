package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.mapper.ActorMapper;
import io.github.enbool.dict.repository.ActorRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * actor Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ActorRepositoryImpl extends ServiceImpl<ActorMapper, Actor> implements ActorRepository {

}
