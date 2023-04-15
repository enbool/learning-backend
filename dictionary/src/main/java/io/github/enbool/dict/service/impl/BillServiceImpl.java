package io.github.enbool.dict.service.impl;

import io.github.enbool.dict.model.entity.Bill;
import io.github.enbool.dict.service.BillService;
import io.github.enbool.dict.repository.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 算力账单 服务实现类
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Service
public class BillServiceImpl  implements BillService{
    @Autowired
    private BillRepository BillRepository;
}
