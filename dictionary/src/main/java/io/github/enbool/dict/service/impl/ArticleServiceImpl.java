package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Article;
import io.github.enbool.dict.service.ArticleService;
import io.github.enbool.dict.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class ArticleServiceImpl  implements ArticleService{
    @Autowired
    private ArticleRepository ArticleRepository;
}
