package io.github.enbool.dict.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.model.form.UserRegisterForm;

import java.util.List;

/**
 * <p>
 * user Repository
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
public interface UserRepository extends IService<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);

    /**
     * 注册管理员
     *
     * @param form
     * @return 用户id
     */
    Long registerAdmin(UserRegisterForm form);
}
