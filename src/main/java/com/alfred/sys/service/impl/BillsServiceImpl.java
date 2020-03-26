package com.alfred.sys.service.impl;

import com.alfred.sys.domain.Bills;
import com.alfred.sys.mapper.BillsMapper;
import com.alfred.sys.service.IBillsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alfred
 * @since 2020-03-14
 */
@Service
public class BillsServiceImpl extends ServiceImpl<BillsMapper, Bills> implements IBillsService {

}
