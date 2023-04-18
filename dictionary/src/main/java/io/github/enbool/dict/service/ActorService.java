package io.github.enbool.dict.service;

import io.github.enbool.dict.model.entity.Actor;
import io.github.enbool.dict.model.vo.ActorVO;

import java.util.List;

/**
 * <p>
 * actor Service
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
public interface ActorService {

    /**
     * list all actor
     * @return
     */
    List<ActorVO> list();

    List<ActorVO> listActive();

    /**
     * find by current user
     * @return
     */
    List<ActorVO> findByCurrentUser();

    /**
     * current user purchase actor
     * @param id
     * @return
     */
    Boolean purchase(Long id);
}
