package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.context.UserContextHolder;
import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.model.vo.ActorVO;
import io.github.enbool.dict.repository.UserActorRepository;
import io.github.enbool.dict.service.ActorService;
import io.github.enbool.dict.repository.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private UserActorRepository userActorRepository;

    @Override
    public List<ActorVO> list() {
        List<Actor> actors = actorRepository.listByStatus(null);
        return actors.stream()
                .map(ActorVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorVO> listActive() {
        List<Actor> actors = actorRepository.listByStatus("active");
        return actors.stream()
                .map(ActorVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorVO> findByCurrentUser() {
        // find actor by current user
        Long userId = UserContextHolder.getUserId();
        List<Long> actorIds = userActorRepository.listByUserId(userId);
        List<Actor> actors = actorRepository.listByIds(actorIds);

        return actors.stream()
                .map(ActorVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean purchase(Long id) {
        Long userId = UserContextHolder.getUserId();
        return null;
    }
}
