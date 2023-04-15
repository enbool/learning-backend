package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.UserBook;
import io.github.enbool.dict.service.UserBookService;
import io.github.enbool.dict.repository.UserBookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Service
public class UserBookServiceImpl  implements UserBookService{
    @Autowired
    private UserBookRepository UserBookRepository;
}
