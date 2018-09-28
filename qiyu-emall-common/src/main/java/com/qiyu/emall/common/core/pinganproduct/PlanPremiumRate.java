package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 险种费率数据
 */
public class PlanPremiumRate {

    //险种代码
    private String planCode;
    // 起始投保年龄
    private Integer startApplyingAge;
    //截止投保年龄
    private Integer endApplyingAge;
    //投保性别代码
    private String applyingGenderCode;
    //保障期限(月)
    private Integer coveragePeriod;
    //缴费期限(月)
    private Integer paymentPeriod;
    //缴别代码
    private String paymentModeSet;
    //起始保单月份
    private Integer startPolicyMonth;
    //截止保单月份
    private Integer endPolicyMonth;
    //起始保单天
    private Integer startPolicyDay;
    //截止保单天
    private Integer endPolicyDay;
    //职业类别代码
    private String occupationGradeCode;
    //保障档次
    private String coverageLevel;
    //费率
    private BigDecimal premiumRate;
    //险种领取选择ID
    private Integer planPayoutOptionId;
    //领取年龄
    private Integer payOutAge;
    //再保部分费率
    private BigDecimal reinsurePremiumRate;
    //非再保部分费率
    private BigDecimal noReinsurePremiumRate;
    //VIT服务收费
    private BigDecimal vitServicePaymentPremium;
    //VIT服务费用
    private BigDecimal vitServiceFeepremium;
    //保障期限(天)
    private Integer coveragePeriodDay;
    //是否有社保(Y/N)
    private String socialSecurity;
    //起始保单年度
    private Integer startPolicyYear;
    //截止保单年度
    private Integer endPolicyYear;

}
