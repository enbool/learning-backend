package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.UserActor;
import io.github.enbool.dict.mapper.UserActorMapper;
import io.github.enbool.dict.repository.UserActorRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Long> listByUserId(Long userId) {
        return this.lambdaQuery()
                .select(UserActor::getActorId)
                .eq(UserActor::getUserId, userId)
                .list()
                .stream()
                .map(UserActor::getActorId)
                .collect(Collectors.toList());
    }
}
