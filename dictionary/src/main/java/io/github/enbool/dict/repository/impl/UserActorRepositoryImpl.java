package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.UserActor;
import io.github.enbool.dict.mapper.UserActorMapper;
import io.github.enbool.dict.repository.UserActorRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user_actor Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class UserActorRepositoryImpl extends ServiceImpl<UserActorMapper, UserActor> implements UserActorRepository {

}
