package io.github.enbool.dict.repository;

import io.github.enbool.dict.model.entity.Actor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * actor Repository
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
public interface ActorRepository extends IService<Actor> {

    /**
     * find by userId and status of actor
     * @param active
     * @return
     */
    List<Actor> listByStatus(String active);
}
