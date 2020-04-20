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
 * 债权表
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_debt")
public class DebtPO implements Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 债权业务ID
     */
    private Long bizDebtId;

    /**
     * 债权编号
     */
    private String debtNo;

    /**
     * 所属债权批次id
     */
    private Long debtBatchId;

    /**
     * 资产类型
     */
    private Integer borrowType;

    /**
     * 所属债权批次业务id
     */
    private Long bizBatchId;

    /**
     * 机构id
     */
    private Long orgId;

    /**
     * 机构代码
     */
    private String orgCode;

    /**
     * 合作机构批次号
     */
    private String orgBatchNo;

    /**
     * 借款人姓名
     */
    private String borrowerName;

    /**
     * 性别 (1为男2为女)
     */
    private Integer borrowerGender;

    /**
     * 借款人居住地址
     */
    private String borrowerAddr;

    /**
     * 借款人职业类型编码
     */
    private String careerCode;

    /**
     * 所属行业编码
     */
    private String industryCode;

    /**
     * 借款人身份证号
     */
    private String idno;

    /**
     * 合同金额（分）
     */
    private Long contractAmount;

    /**
     * 利息(分)
     */
    private Long interest;

    /**
     * 借款期限
     */
    private Integer loanPeriods;

    /**
     * 借款期限类型
     */
    private Integer loanPeriodsType;

    /**
     * 借款年化利率
     */
    private BigDecimal annualRate;

    /**
     * 还款方式（1、一次性本息还款2、等额本息3、先息后本4、等本等息）
     */
    private Integer repaymentMode;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 借款用途
     */
    private String loanPurpose;

    /**
     * 银行卡号
     */
    private String cardNo;

    /**
     * 银行编号
     */
    private String bankNo;

    /**
     * 放款金额(分)
     */
    private Long loanAmount;

    /**
     * 资产标签（0：债转结清再贷资产；2：直投结清再贷资产；3：直投资产；4：加保资产；5：非加保资产）
     */
    private Integer debtLabel;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 支行
     */
    private String bankBranch;

    /**
     * 开户地（省，市）
     */
    private String bankAddr;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 债权到期日 提前还款时修改，后续业务以这个字段作为债权到期日，算利息相关的
     */
    private LocalDate dueDate;

    /**
     * 原到期日
     */
    private LocalDate dueDateOriginal;

    /**
     * 匹配状态 0：未匹配 1：已匹配
     */
    private Integer matchStatus;

    /**
     * 使用状态 0：未使用 1：已使用 2 : 已删除
     */
    private Integer useStatus;

    /**
     * 推送状态：0未推送，1已推送
     */
    private Integer pushStatus;

    /**
     * 推送时间
     */
    private LocalDateTime pushTime;

    /**
     * 到期状态 0提前还款  1已到期 2未到期
     */
    private Integer expiredStatus;

    /**
     * 渠道费用(分)
     */
    private Long channelFee;

    /**
     * 借款人开户身份标识
     */
    private String openId;

    /**
     * 居间协议编号
     */
    private String intermediaryAgreementCode;

    /**
     * 原始年利率
     */
    private BigDecimal oriAnnualRate;

    /**
     * 放款类型（1：放款给借款人；2：放款给商户；3：债权重组放款）
     */
    private Integer loanType;

    /**
     * 营业执照编号（放款类型为2时，必填）
     */
    private String businessNo;

    /**
     * 委托代付合同编号（放款类型为2时，必填, 放款类型为1，则填orgCode_debtNo）
     */
    private String consignContractCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 提前还款日期
     */
    private LocalDateTime earlyRepayDate;

    /**
     * 服务费日
     */
    private Integer serviceFeeDate;

    /**
     * 特殊债权：普通为 0  特殊为 1, 针对存量的特殊的债权字段
     */
    private Integer specialType;

    /**
     * 原散标ID
     */
    private Long borrowId;

    /**
     * 原合作机构编号
     */
    private String orgCodeOriginal;

    /**
     * 原合作机构id
     */
    private Long orgIdOriginal;

    /**
     * 是否加保产品（默认-1表示不关注是否加保）：1.是；2.否
     */
    private Integer additionalProductType;

    /**
     * 放款交易类型：00表示T+0，01表示T+1，10表示D+0，11表示D+1
     */
    private String loanTradeType;

    /**
     * 债权起息日
     */
    private LocalDate interestDateStart;

    /**
     * 债权止息日
     */
    private LocalDate interestDateEnd;

    /**
     * 债权推送类型：1单个推送，2批量推送
     */
    private Integer pushType;


}
