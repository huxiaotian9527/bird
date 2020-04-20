package com.hu.boot.bird.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.boot.bird.nfcs.entity.DebtBatchPO;
import com.hu.boot.bird.nfcs.entity.DebtOriginalPO;
import com.hu.boot.bird.nfcs.mapper.DebtBatchMapper;
import com.hu.boot.bird.nfcs.mapper.DebtOriginalMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * mybatis-plus常见用法
 * @Author hutiantian
 * @Date 2020/4/20 18:00:30
 */
@Slf4j
public class MybatisPlusController {

    private DebtOriginalMapper debtOriginalMapper;

    private DebtBatchMapper debtBatchMapper;

    public void mybatisPlus(){
        //1.分页查询
        String orgArray = "";
        QueryWrapper<DebtOriginalPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("org_code", orgArray.split(","));
        //不返回总记录数 设置false
        int pageNum = 5;
        int handlerNum = 10;
        Page<DebtOriginalPO> page = new Page<>(pageNum, handlerNum, false);
        IPage<DebtOriginalPO> iPage = debtOriginalMapper.selectPage(page, queryWrapper);
        List<DebtOriginalPO>  debtOriginalPOList = iPage.getRecords();
        //2.普通查询
        QueryWrapper<DebtOriginalPO> wrapper = new QueryWrapper<>();
        wrapper.eq("report_type", "");
        wrapper.eq("business_num","123456");
        wrapper.orderByDesc("cur_period").last("limit 1");
        DebtOriginalPO po = debtOriginalMapper.selectOne(wrapper);
        //3.自定义sql查询
        DebtBatchPO debtBatchPO = debtBatchMapper.selectByDebtNo("123456");
        log.info("查询大豆的结果为："+po.getBatchNo());

    }
}
