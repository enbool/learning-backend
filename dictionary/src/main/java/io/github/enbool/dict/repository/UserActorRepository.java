package io.github.enbool.dict.repository;

import io.github.enbool.dict.model.entity.UserActor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * user_actor Repository
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
public interface UserActorRepository extends IService<UserActor> {

    /**
     * find id list of actor by userId
     * @param userId
     * @return
     */
    List<Long> listByUserId(Long userId);
}
