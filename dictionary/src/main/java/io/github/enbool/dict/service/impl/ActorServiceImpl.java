package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.service.ActorService;
import io.github.enbool.dict.repository.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * actor 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ActorServiceImpl  implements ActorService{
    @Autowired
    private ActorRepository actorRepository;
}
