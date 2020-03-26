package com.alfred.sys.controller;


import com.alfred.common.DataGridView;
import com.alfred.sys.service.IBilltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alfred
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/billtype")
public class BilltypeController {

    @Autowired
    private IBilltypeService billtypeService;

    @RequestMapping("loadAllBillType")
    public DataGridView loadAllBillType(){

        return new DataGridView(0L,billtypeService.list());
    }


}

