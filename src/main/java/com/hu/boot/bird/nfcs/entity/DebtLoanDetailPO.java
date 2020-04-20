package com.hu.boot.bird.nfcs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 债权放款明细表
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_debt_loan_detail")
public class DebtLoanDetailPO implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 债权id
     */
    private Long debtId;

    /**
     * 债权编号
     */
    private String debtNo;

    /**
     * 债权批次id
     */
    private Long debtBatchId;

    /**
     * 合作方收款姓名
     */
    private String uname;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 订单号
     */
    private String payOrderNo;

    /**
     * 冻结订单号
     */
    private String freezeOrderNo;

    /**
     * 解冻订单号
     */
    private String unfreezeOrderNo;

    /**
     * 解冻状态：0未解冻，1已解冻
     */
    private Integer unfreezeStatus;

    /**
     * 打款金额
     */
    private Long amount;

    /**
     * 保险费金额
     */
    private Long premiumAmount;

    /**
     * 保费金额对账结果：-1不需要对账，0对账结果不一致，1对账结果一致
     */
    private Integer premiumAmountCompareResult;

    private String bankNo;

    /**
     * 需放款日期
     */
    private LocalDateTime repayDate;

    /**
     * 实际放款日期
     */
    private LocalDateTime repayDateActual;

    /**
     * 第三方系统打款状态代码：RC已接收  SE系统异常  SS处理成功 UN用户不存在  AF账户被冻结  NT用户未开通转账功能  线下打款成功
     */
    private String thirdCode;

    /**
     * 提现类型：1自动提现，2手动提现
     */
    private Integer depositType;

    /**
     * 提现状态（0:不可提现;1:可提现;2:提现受理中;3:提现已受理;4:提现受理失败）
     */
    private Integer depositStatus;

    /**
     * 提现受理时间
     */
    private LocalDateTime depositTime;

    /**
     * 放款状态 1:未放款 2:已提交 3:放款失败 4:放款成功
     */
    private Integer loanStatus;

    /**
     * 反馈状态 0:未反馈 1:已经反馈
     */
    private Integer feedbackStatus;

    /**
     * 短信发送状态：00 无需发送
10 准备发送还款成功短信 11 发送还款成功短信完成
20 准备发送还款失败短信 21 发送还款失败短信成功
30 准备发送线下还款成功短信 31 发送线下还款成功短信完成
     */
    private String smsStatus;

    /**
     * 校验码
     */
    private String verifyCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 存管银行返回信息
     */
    private String thirdRemark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用于生成合同标识(0表示未生成合同,1表示生成合同成功)
     */
    private Integer contractStatus;


}
