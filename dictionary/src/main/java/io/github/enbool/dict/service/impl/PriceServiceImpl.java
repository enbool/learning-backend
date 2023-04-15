package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Price;
import io.github.enbool.dict.service.PriceService;
import io.github.enbool.dict.repository.PriceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 服务价格表 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class PriceServiceImpl  implements PriceService{
    @Autowired
    private PriceRepository PriceRepository;
}
