package com.hu.boot.bird.nfcs.entity;

import java.math.BigDecimal;
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
 * 原始债权表（通过接口请求获取的原始债权数据）
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_debt_original")
public class DebtOriginalPO implements Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 记录编号(唯一)
     */
    private String debtNo;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构id
     */
    private Long orgId;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 姓名
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
     * 居住详细地址
     */
    private String houseAddress;

    /**
     * 借款人职业类型编码
     */
    private String careerCode;

    /**
     * 所属行业编码
     */
    private String industryCode;

    /**
     * 证件号码
     */
    private String idno;

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
     * 营业执照编号（放款类型为2时，必填）
     */
    private String businessNo;

    /**
     * 委托代付合同编号（放款类型为2时，必填, 放款类型为1，则填orgCode_debtNo）
     */
    private String consignContractCode;

    /**
     * 借款金额
     */
    private Long borrowContractAmount;

    /**
     * 借款期限类型 (1、天 2、月)
     */
    private Integer loanPeriodsType;

    /**
     * 借款期数
     */
    private Integer loanPeriods;

    /**
     * 利率 (12,8)
     */
    private BigDecimal annualRate;

    /**
     * 还款方式（1、一次性本息还款2、等额本息3、先息后本4、等本等息）
     */
    private Integer repaymentMode;

    /**
     * 贷款产品类型
     */
    private String productType;

    /**
     * 银行卡号
     */
    private String cardNo;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 支行
     */
    private String bankBranch;

    /**
     * 银行卡编号
     */
    private String bankNo;

    /**
     * 开户省份
     */
    private String bankAddr;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 借款人合同编号
     */
    private String borrowerContractNo;

    /**
     * 申请借款用途
     */
    private String loanPurpose;

    /**
     * 月还款额
     */
    private Long monthRepayAmount;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 扩展信息 (大字段，列表上不需要展示的)
     */
    private String extendData;

    /**
     * 是否对商户放款（null:否，1：是）
     */
    private Integer isLoanBusiness;

    /**
     * 操作者用户名
     */
    private String auditUsername;

    /**
     * 放款金额
     */
    private Long loanAmount;

    /**
     * 资产标签（0：债转结清再贷资产；2：直投结清再贷资产；3：直投资产；4：加保资产；5：非加保资产）
     */
    private Integer debtLabel;

    /**
     * 债权状态 0为初始状态 1为打款成功 2为风控审核通过 3待债权确认,已风控审核通过 4债权已确认 7为风控审核不通过退回 8为未募集满退回 9为打款失败退回 10为合作机构撤回债权 12 债权登记失败退回 13 债权未开户退回 14 债权未授权退回 21 交叉放款校验退回
     */
    private Integer status;

    /**
     * 风控审核状态  0 待审核，1 已审核，2 审核不通过，3 风控初审通过，4 风控初审不通过
     */
    private Integer auditStatus;

    /**
     * 债权登记状态，U 初始状态 ，P 处理中 S 成功 F 失败
     */
    private String entrustStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 债权登记状态，U 初始状态 ，P 处理中 S 成功 F 失败
     */
    private String checkInStatus;

    /**
     * 资产类型编码 默认填0 1.线上信用贷 2.线下信用贷 3.用户消费分期-C 4.消费分期-B 5.车辆质押 6车辆抵押 7应收账款质押
     */
    private Integer assetType;

    private Integer fileStatus;

    /**
     * 放款类型（1：放款给借款人；2：放款给商户；3：债权重组放款）
     */
    private Integer loanType;

    /**
     * 特殊债权：普通为 0  特殊为 1, 针对存量的特殊的债权字段
     */
    private Integer specialType;

    /**
     * 原散标ID
     */
    private Long borrowId;

    /**
     * 服务费日
     */
    private Integer serviceFeeDate;

    /**
     * 借款人类型 默认填1 1.个人借款人 2.企业借款人
     */
    private Integer borrowerType;

    /**
     * 客户评级(A-E)
     */
    private String customerLevel;

    /**
     * 客户评分(0-100)
     */
    private BigDecimal customerScore;

    /**
     * 是否加保产品（默认-1表示不关注是否加保）：1.是；2.否
     */
    private Integer additionalProductType;

    /**
     * 放款交易类型：00表示T+0，01表示T+1，10表示D+0，11表示D+1
     */
    private String loanTradeType;

    /**
     * 趸交比例值
     */
    private BigDecimal singlePremiumRate;


}
