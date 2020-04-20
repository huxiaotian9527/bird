package com.hu.boot.bird.nfcs.entity;

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
 * 
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_loan_rate_info")
public class LoanRateInfoPO implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 贷款申请号
     */
    private String debtNo;

    /**
     * 贷款业务号
     */
    private String businessNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardNum;

    /**
     * 贷款业务类型
     */
    private String loanType;

    /**
     * 贷款申请金额
     */
    private String loanAmount;

    /**
     * 贷款申请月数
     */
    private String loanMonths;

    /**
     * 贷款申请时间
     */
    private String loanApplyTime;

    /**
     * 贷款申请状态
     */
    private String loanApplyStatus;

    /**
     * 贷款授信额度
     */
    private String limit;

    /**
     * 贷款综合利率
     */
    private String rate;

    /**
     * 报送日期
     */
    private LocalDate reportDate;

    /**
     * 数据对应文件信息
     */
    private String reportFile;

    /**
     * 数据状态（-1:不需要报送; 0:未处理; 1:处理中; 2:处理成功; 3:处理失败）
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
