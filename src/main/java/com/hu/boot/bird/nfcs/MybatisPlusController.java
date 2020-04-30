package com.hu.boot.bird.nfcs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.boot.bird.nfcs.entity.DebtOriginalPO;
import com.hu.boot.bird.nfcs.mapper.DebtOriginalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * mybatis-plus常见用法
 * @Author hutiantian
 * @Date 2020/4/20 18:00:30
 */
@Slf4j
public class MybatisPlusController {

    @Autowired
    private DebtOriginalMapper debtOriginalMapper;

    private static int handlerNum = 1000;
    private static int threadNum = 10;

    /**
     * 复杂查询
     */
    public void test1(){
        //-------------------------------普通查询------------------------------
        QueryWrapper<DebtOriginalPO> wrapper = new QueryWrapper<>();
        //等值条件
        wrapper.eq("debt_no", "");
        //大于等于
        wrapper.ge("use_time_start", "");
        //小于
        wrapper.lt("use_time_start", "");
        //in
        wrapper.in("org_code", new String[]{});
        //从小到大排序
        wrapper.orderByAsc("month");
        //limit
        wrapper.last("limit 1");
        DebtOriginalPO debtLoanDetailPO = debtOriginalMapper.selectOne(wrapper);

        //-------------------------------自定义sql查询------------------------------
        DebtOriginalPO debtOriginalPO = debtOriginalMapper.selectByDebtNo("123456");

        //-------------------------------分页查询------------------------------
        String orgArray = "";
        QueryWrapper<DebtOriginalPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("org_code", orgArray.split(","));
        //不返回总记录数 设置false
        int pageNum = 5;
        int handlerNum = 10;
        Page<DebtOriginalPO> page = new Page<>(pageNum, handlerNum, false);
        IPage<DebtOriginalPO> iPage = debtOriginalMapper.selectPage(page, queryWrapper);
        List<DebtOriginalPO>  debtOriginalPOList = iPage.getRecords();

    }

    /**
     * 多线程分页查询，提高单机处理能力
     */
    public void test(){
        String orgArray = "";
        QueryWrapper<DebtOriginalPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("org_code", orgArray.split(","));
        for (int i = 1; i < threadNum+1; i++) {
            final Integer cur = i;
            new Thread(() -> {
                int page = cur;
                while (true) {
                    List<DebtOriginalPO> debtOriginalPOList = getPageData(queryWrapper, page);
                    if (debtOriginalPOList != null && debtOriginalPOList.size() > 0) {
//                        stockHandler(debtOriginalPOList);     do something
                        page = page + threadNum;
                    } else {
                        break;
                    }
                }
            }).start();
        }
    }

    /**
     * 分页查询数据
     */
    private List<DebtOriginalPO> getPageData(QueryWrapper queryWrapper, int pageNum) {
        //不返回总记录数 设置false
        Page<DebtOriginalPO> page = new Page<>(pageNum, handlerNum, false);
        IPage<DebtOriginalPO> iPage = debtOriginalMapper.selectPage(page, queryWrapper);
        return iPage.getRecords();
    }

}
