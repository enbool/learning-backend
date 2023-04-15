package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.UserActor;
import io.github.enbool.dict.service.UserActorService;
import io.github.enbool.dict.repository.UserActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * user_actor 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class UserActorServiceImpl  implements UserActorService{
    @Autowired
    private UserActorRepository UserActorRepository;
}
