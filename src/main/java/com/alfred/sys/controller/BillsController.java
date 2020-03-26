package com.alfred.sys.controller;


import com.alfred.common.DataGridView;
import com.alfred.common.ResulObj;
import com.alfred.sys.domain.Bills;
import com.alfred.sys.domain.Billtype;
import com.alfred.sys.service.IBillsService;
import com.alfred.sys.service.IBilltypeService;
import com.alfred.sys.vo.BillsVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alfred
 * @since 2020-03-14
 */
@Controller
@RequestMapping("bills")
public class BillsController {

    @Autowired
    private IBillsService billsService;

    @Autowired
    private IBilltypeService iBilltypeService;

    /**
     * 跳转到系统主页
     * @return
     */
    @RequestMapping("toBillsList")
    public String toBillsList(){
        return "list";
    }

    /**
     * 加载账单的数据
     * @return
     */
    @RequestMapping("loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillsVo billsVo){
        IPage<Bills> page = new Page<>(billsVo.getPage(),billsVo.getLimit());
        QueryWrapper<Bills> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(null!=billsVo.getTypeid()&&billsVo.getTypeid()!=0,"typeid",billsVo.getTypeid());
        //大于等于开始时间 小于等于结束时间
        queryWrapper.ge(billsVo.getStartDate()!=null,"billtime",billsVo.getStartDate());
        queryWrapper.le(billsVo.getEndDate()!=null,"billtime",billsVo.getEndDate());
        queryWrapper.orderByDesc("billtime");
        billsService.page(page,queryWrapper);
        List<Bills> records = page.getRecords();
        List<Billtype> list = iBilltypeService.list();
        for (Bills bills:records){
            Billtype byId = this.iBilltypeService.getById(bills.getTypeid());
            bills.setTypeName(byId.getName());

        }
        return new DataGridView(page.getTotal(),page.getRecords());
    }
    /**
     * 添加账单
     */
    /**
     * 添加账单
     */
    @RequestMapping("addBills")
    @ResponseBody
    public ResulObj addBills(BillsVo billsVo) {
        try {
            this.billsService.save(billsVo);
            return new ResulObj(200, "录入成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResulObj(-1, "录入失败");
        }
    }
}

