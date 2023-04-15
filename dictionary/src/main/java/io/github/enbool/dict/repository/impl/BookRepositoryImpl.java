package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Book;
import io.github.enbool.dict.mapper.BookMapper;
import io.github.enbool.dict.repository.BookRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class BookRepositoryImpl extends ServiceImpl<BookMapper, Book> implements BookRepository {

}
