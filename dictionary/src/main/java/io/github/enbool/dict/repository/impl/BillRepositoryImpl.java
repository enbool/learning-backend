package io.github.enbool.dict.repository.impl;

import io.github.enbool.dict.model.entity.Bill;
import io.github.enbool.dict.mapper.BillMapper;
import io.github.enbool.dict.repository.BillRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 算力账单 Repository Implementation
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class BillRepositoryImpl extends ServiceImpl<BillMapper, Bill> implements BillRepository {

}
