package com.alfred.sys.service.impl;

import com.alfred.sys.domain.Billtype;
import com.alfred.sys.mapper.BilltypeMapper;
import com.alfred.sys.service.IBilltypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alfred
 * @since 2020-03-14
 */
@Service
public class BilltypeServiceImpl extends ServiceImpl<BilltypeMapper, Billtype> implements IBilltypeService {

    @Override
    public Billtype getById(Serializable id) {
        return super.getById(id);
    }
}
