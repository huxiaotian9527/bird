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
@TableName("t_borrower_info")
public class BorrowerInfoPO implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 证件号
     */
    private String cardNum;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private String birthDay;

    /**
     * 婚姻状况
     */
    private String marital;

    /**
     * 最高学历
     */
    private String highestEducation;

    /**
     * 最高学位
     */
    private String highestDegree;

    /**
     * 住宅电话
     */
    private String homePhone;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 单位电话
     */
    private String workPhone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 通讯地址
     */
    private String contactAddr;

    /**
     * 通讯地址邮政编码
     */
    private String contactPostcode;

    /**
     * 户籍地址
     */
    private String hoseholdregistAddr;

    /**
     * 配偶姓名
     */
    private String spouseName;

    /**
     * 配偶证件类型
     */
    private String spouseCerttype;

    /**
     * 配偶证件号码
     */
    private String spouseCertno;

    /**
     * 配偶工作单位
     */
    private String spouseWorkspaceName;

    /**
     * 配偶联系电话
     */
    private String spouseMobilePhone;

    /**
     * 职业
     */
    private String profession;

    /**
     * 单位名称
     */
    private String workspaceName;

    /**
     * 单位所属行业
     */
    private String workspaceType;

    /**
     * 单位地址
     */
    private String workspaceAddr;

    /**
     * 单位邮政编码
     */
    private String postalCode;

    /**
     * 本单位工作起始年份
     */
    private String workStartYear;

    /**
     * 职务
     */
    private String position;

    /**
     * 职称
     */
    private String title;

    /**
     * 年收入
     */
    private String annualIncome;

    /**
     * 工资帐号
     */
    private String incomeAccountNo;

    /**
     * 工资账户开户行
     */
    private String incomeBank;

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
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;


}
