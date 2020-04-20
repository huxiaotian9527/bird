package com.hu.boot.bird.nfcs.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 债权回款明细表
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_debt_payback_detail")
public class DebtPaybackDetailPO implements Serializable {


    /**
     * id 自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long tmpId;

    /**
     * 计划类型
     */
    private Integer templateType;

    /**
     * 债权id
     */
    private Long debtId;

    /**
     * 债权编号
     */
    private String debtNo;

    /**
     * 债权包id
     */
    private Long debtBatchId;

    /**
     * 回款总期数
     */
    private Integer totalPeriods;

    /**
     * 当前期
     */
    private Integer currentPeriods;

    /**
     * 回款总金额(本息) 单位分
     */
    private Long totalAmount;

    /**
     * 回款本金 单位分
     */
    private Long principal;

    /**
     * 回款利息 单位分
     */
    private Long interest;

    /**
     * 待充值金额
     */
    private Long pendingAmount;

    /**
     * 剩余本金 单位分
     */
    private Long remainPrincipal;

    /**
     * 止息日 债匹相关用的都是止息日字段 
     */
    private LocalDate interestDateEnd;

    /**
     * 计划止息日
     */
    private LocalDate planInterestDateEnd;

    /**
     * 回款日期 一般是止息日后的第一个工作日
     */
    private LocalDate paybackDate;

    /**
     * 到期日
     */
    private LocalDate dueDate;

    /**
     * 每一期的通道费 单位分
     */
    private BigDecimal channelFee;

    /**
     * 轮询状态 0未处理  1为已处理 
     */
    private Integer status;

    /**
     * 1:表示已经推送到非标，0表示未推送
     */
    private Integer pushStatus;

    /**
     * 数据比对状态，0 默认(未比对)， 1 比对正确，2 比对错误，3 合作方比对
     */
    private Integer diffStatus;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 逾期状态，0:默认值,1:未逾期,2:逾期未偿,3:逾期已代偿
     */
    private Integer overdueStatus;

    /**
     * 平台服务费收取状态，0:默认值,1:受理申请成功,2:划转成功,3:划转失败
     */
    private Integer chargeStatus;

    /**
     * 合作机构服务费收取状态，0:默认值,1:受理申请成功,2:划转成功,3:划转失败,4:服务费异常
     */
    private Integer orgChargeStatus;

    /**
     * 充值状态，0:默认值,1:受理申请成功,2:充值成功,3:充值失败
     */
    private Integer rechargeStatus;

    /**
     * 放款状态，0未确认，1确认成功（放款成功）2确认失败（放款失败）
     */
    private Integer loanStatus;

    /**
     * 还款类型 0:正常还款,1:提前结清,2:逾期还款,3:当期提前还款
     */
    private Integer repayType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 回款流水号
     */
    private String batchNo;

    /**
     * 回款账单号
     */
    private String paybackBillNo;

    /**
     * 实际回款日期
     */
    private LocalDate realPaybackDate;

    /**
     * 实际充值日期
     */
    private LocalDate realRechargeDate;

    /**
     * 提前还款应退服务费（单位：分）
     */
    private Long earlyRepayReturnChannelFee;

    /**
     * 机构服务费，默认为0
     */
    private Long orgServiceFee;

    /**
     * 机构代码
     */
    private String orgCode;

    /**
     * 合同编号
     */
    private String contractNo;


}
