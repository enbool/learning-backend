package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Article;
import io.github.enbool.dict.mapper.ArticleMapper;
import io.github.enbool.dict.repository.ArticleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ArticleRepositoryImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleRepository {

}
