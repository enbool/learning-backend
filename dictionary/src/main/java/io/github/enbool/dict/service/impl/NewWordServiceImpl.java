package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.NewWord;
import io.github.enbool.dict.service.NewWordService;
import io.github.enbool.dict.repository.NewWordRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 生词本 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class NewWordServiceImpl  implements NewWordService{
    @Autowired
    private NewWordRepository NewWordRepository;
}
