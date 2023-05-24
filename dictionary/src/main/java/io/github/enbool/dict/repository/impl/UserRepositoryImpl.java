package io.github.enbool.dict.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.exception.BusinessException;
import io.github.enbool.dict.mapper.UserMapper;
import io.github.enbool.dict.model.entity.User;
import io.github.enbool.dict.model.enums.UserType;
import io.github.enbool.dict.model.form.UserRegisterForm;
import io.github.enbool.dict.repository.UserRepository;
import io.github.enbool.dict.utils.AssertUtils;
import io.github.enbool.dict.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * <p>
 * user Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Slf4j
@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return this.lambdaQuery()
                .eq(User::getUsername, username)
                .one();
    }

    public User findByEmail(String email) {
        return this.lambdaQuery()
                .eq(User::getEmail, email)
                .one();
    }

    public User findByPhone(String phone) {
        return this.lambdaQuery()
                .eq(User::getPhone, phone)
                .one();
    }

    @Override
    public Long registerAdmin(UserRegisterForm form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        User user = form.convert();
        user.setUserType(UserType.ADMIN);
        user.setEnabled(true);

        try {
            save(user);
            return user.getId();
        } catch (Exception e) {
            log.error("registerAdmin error, form: [{}]", JsonUtils.toJsonString(form), e);
            User byUsername = findByUsername(user.getUsername());
            AssertUtils.requireNull(byUsername, BusinessErrorEnum.USERNAME_EXIST);
            User byEmail = findByEmail(user.getEmail());
            AssertUtils.requireNull(byEmail, BusinessErrorEnum.EMAIL_EXIST);
            User byPhone = findByPhone(user.getPhone());
            AssertUtils.requireNull(byPhone, BusinessErrorEnum.PHONE_EXIST);

            throw new BusinessException(BusinessErrorEnum.DB_ERROR);
        }
    }
}
