package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Book;
import io.github.enbool.dict.service.BookService;
import io.github.enbool.dict.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 书籍 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class BookServiceImpl  implements BookService{
    @Autowired
    private BookRepository BookRepository;
}
