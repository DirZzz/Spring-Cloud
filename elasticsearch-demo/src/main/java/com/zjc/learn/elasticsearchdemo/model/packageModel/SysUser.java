package com.zjc.learn.elasticsearchdemo.model.packageModel;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author author
 */
@Data
@Entity
@Document(indexName = "userIndex",type = "user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1525491830342L;


    /**
     * 主键
     * <p>
     * isNullAble:0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     * isNullAble:1
     */
    private String userName;

    /**
     * 昵称
     * isNullAble:1
     */
    private String nickName;

    /**
     * 移动
     * isNullAble:1
     */
    private String mobile;

    /**
     * 密码
     * isNullAble:1
     */
    private String password;

    /**
     * 邮箱
     * isNullAble:1
     */
    private String email;

    /**
     * 用户类型
     * isNullAble:1
     */
    private Integer userType;

    /**
     * 性别
     * isNullAble:1
     */
    private Integer sex;

    /**
     * 职业
     * isNullAble:1
     */
    private String job;

    /**
     * 区域
     * isNullAble:1
     */
    private Integer areaId;

    /**
     * isNullAble:1
     */
    private Integer picId;

    /**
     * 媒介类型
     * isNullAble:1
     */
    private Integer mediaType;

    /**
     * isNullAble:1
     */
    private String sysCode;

    /**
     * 创建者
     * isNullAble:1
     */
    private String creator;

    /**
     * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
     */
    private java.time.LocalDateTime gmtCreate;

    /**
     * 修改人
     * isNullAble:1
     */
    private String modifier;

    /**
     * 修改时间
     * isNullAble:0,defaultVal:0000-00-00 00:00:00
     */
    private java.time.LocalDateTime gmtModified;

    /**
     * 是否删除
     * isNullAble:1,defaultVal:0
     */
    private Integer isDeleted;

    /**
     * isNullAble:1
     */
    private String appKey;

    /**
     * 字符备用2
     * isNullAble:1
     */
    private String token;

    /**
     * 字符备用3
     * isNullAble:1
     */
    private String att3;

    /**
     * 字符备用4
     * isNullAble:1
     */
    private String att4;

    /**
     * 字符备用5
     * isNullAble:1
     */
    private String att5;

    /**
     * 字符备用6
     * isNullAble:1
     */
    private String att6;

    /**
     * 时间备用1
     * isNullAble:0,defaultVal:0000-00-00 00:00:00
     */
    private java.time.LocalDateTime dateAtt1;

    /**
     * 时间备用2
     * isNullAble:0,defaultVal:0000-00-00 00:00:00
     */
    private java.time.LocalDateTime dateAtt2;

    /**
     * 组织id
     * isNullAble:0
     */
    private Integer groupId;

    /**
     * 整数备用2
     * isNullAble:1
     */
    private Integer numAtt2;

    /**
     * 数字备用1
     * isNullAble:1
     */
    private java.math.BigDecimal numAtt3;

    /**
     * 数字备用2
     * isNullAble:1
     */
    private java.math.BigDecimal numAtt4;

    /**
     * 备注
     * isNullAble:1
     */
    private String remark;

    /**
     * 真实名字
     * isNullAble:1
     */
    private String realName;

    /**
     * QQ号码
     * isNullAble:1
     */
    private String qq;

    /**
     * 公司电话
     * isNullAble:1
     */
    private String companyTel;

    /**
     * 公司地址
     * isNullAble:1
     */
    private String companyAddress;

    /**
     * isNullAble:1
     */
    private String specialityValue;

    /**
     * isNullAble:1
     */
    private String intro;

    /**
     * isNullAble:1,defaultVal:0
     */
    private Integer emailVerifyState;

    /**
     * isNullAble:1,defaultVal:0
     */
    private Integer mobileVerifyState;

    /**
     * isNullAble:1,defaultVal:0
     */
    private Integer idcardVerifyState;

    /**
     * isNullAble:1
     */
    private Integer lEVEL;

    /**
     * isNullAble:0,defaultVal:0000-00-00 00:00:00
     */
    private java.time.LocalDateTime applicationDate;

    /**
     * isNullAble:1
     */
    private String verifyUser;

    /**
     * isNullAble:0,defaultVal:0000-00-00 00:00:00
     */
    private java.time.LocalDateTime verifyDate;

    /**
     * isNullAble:1
     */
    private String areaLongCode;

    /**
     * isNullAble:1
     */
    private String reasonRejected;

    /**
     * isNullAble:1
     */
    private String brandIds;

    /**
     * isNullAble:1,defaultVal:
     */
    private String userImei;

    /**
     * isNullAble:1,defaultVal:0.00
     */
    private java.math.BigDecimal consumAmount;

    /**
     * isNullAble:1,defaultVal:0.00
     */
    private java.math.BigDecimal balanceAmount;

    /**
     * 详细地址
     * isNullAble:1
     */
    private String address;

    /**
     * 消费总积分
     * isNullAble:1,defaultVal:0
     */
    private Integer consumIntegral;

    /**
     * 账号积分
     * isNullAble:1,defaultVal:0
     */
    private Integer balanceIntegral;

    /**
     * 可用户型套数
     * isNullAble:1,defaultVal:0
     */
    private Integer usableHouseNumber;

    /**
     * 网卡校验限制(1:允许所有类型网卡登录，2:所有网卡均不允许登录，3:仅允许PCI网卡登录，4:仅允许USB网卡登录，5:取消设备限制)
     * isNullAble:1,defaultVal:3
     */
    private Integer networkCardRestrict;

    /**
     * 是否开通移动端(0:未开通，1：已开通)
     * isNullAble:1,defaultVal:0
     */
    private Integer existsMobile;

    /**
     * 移动端开通时间
     * isNullAble:1
     */
    private java.time.LocalDate mobileOpenedDate;

    /**
     * 移动端截止时间
     * isNullAble:1
     */
    private java.time.LocalDate mobileClosedDate;

    /**
     * 游客可渲染次数，默认5次
     * isNullAble:1,defaultVal:5
     */
    private Integer visitorsRenderTimes;

}
