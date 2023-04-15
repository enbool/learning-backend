package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.UserBook;
import io.github.enbool.dict.mapper.UserBookMapper;
import io.github.enbool.dict.repository.UserBookRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Service
public class UserBookRepositoryImpl extends ServiceImpl<UserBookMapper, UserBook> implements UserBookRepository {

}
