package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.mapper.ActorMapper;
import io.github.enbool.dict.repository.ActorRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<Actor> listByStatus(String status) {
        return this.lambdaQuery()
                .eq(StringUtils.isNotBlank(status), Actor::getStatus, status)
                .list();
    }
}
