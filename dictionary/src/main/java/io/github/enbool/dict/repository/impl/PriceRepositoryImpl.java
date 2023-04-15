package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Price;
import io.github.enbool.dict.mapper.PriceMapper;
import io.github.enbool.dict.repository.PriceRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务价格表 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class PriceRepositoryImpl extends ServiceImpl<PriceMapper, Price> implements PriceRepository {

}
