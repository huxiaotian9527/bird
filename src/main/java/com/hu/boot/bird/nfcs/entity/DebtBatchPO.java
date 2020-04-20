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
 * 债权包信息
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_debt_batch")
public class DebtBatchPO implements Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 债权批次（包）业务ID
     */
    private Long bizBatchId;

    /**
     * 批次名称
     */
    private String batchName;

    /**
     * 债权批次编号
     */
    private String batchNo;

    /**
     * 合作机构id
     */
    private Long orgId;

    /**
     * 合作机构代码
     */
    private String orgCode;

    /**
     * 合同金额（分）
     */
    private Long contractAmount;

    /**
     * 放款前合同金额（分），包括放款失败金额
     */
    private Long originalContractAmount;

    /**
     * 放款前债权数，包括放款失败数
     */
    private Integer originalDebtCount;

    /**
     * 回款年利率
     */
    private BigDecimal annualRatePayback;

    /**
     * 借款期限
     */
    private Integer loanPeriods;

    /**
     * 借款期限类型 (1、天 2、月)
     */
    private Integer loanPeriodsType;

    /**
     * 还款方式（1、一次性本息还款2、等额本息3、先息后本4、等本等息）
     */
    private Integer repaymentMode;

    /**
     * 打包费率
     */
    private BigDecimal packRate;

    /**
     * 债权批次使用开始时间
     */
    private LocalDateTime useTimeStart;

    /**
     * 债权批次使用结束时间
     */
    private LocalDateTime useTimeEnd;

    /**
     * 债权批次到期日
     */
    private LocalDate dueDate;

    /**
     * 已使用金额（分
     */
    private Long usedAmount;

    /**
     * 未使用金额（分）
     */
    private Long unusedAmount;

    /**
     * 状态：0为未使用，1为已使用
     */
    private Integer useStatus;

    /**
     * 债权批次放款状态：0 未放款  1 已结生成放款明细 2 已经提交放款
     */
    private Integer loanStatus;

    /**
     * 放款交易类型：00表示T+0，01表示T+1，10表示D+0，11表示D+1
     */
    private String loanTradeType;

    /**
     * 推送状态：0未推送，1已推送
     */
    private Integer pushStatus;

    /**
     * 业务渠道：1非标，2活期
     */
    private Integer bizChannel;

    /**
     * 业务类型：1计划类，2非计划类
     */
    private Integer bizType;

    /**
     * 计划id
     */
    private Long tmpId;

    /**
     * 计划类型名称
     */
    private String tmpName;

    /**
     * 产品类别：1:月月高、2:季季高、3:单标等
     */
    private Integer productCategory;

    /**
     * 产品名
     */
    private String productName;

    /**
     * 回款类型：0正常回款，1提前回款
     */
    private Integer repaymentType;

    /**
     * 产品ID：t_product.id
     */
    private String productId;

    /**
     * 组合订单号
     */
    private String packOrderNo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
