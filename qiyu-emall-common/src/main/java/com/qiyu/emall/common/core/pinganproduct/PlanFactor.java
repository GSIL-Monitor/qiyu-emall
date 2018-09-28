package com.qiyu.emall.common.core.pinganproduct;

/**
 * 险种各类相关性定义表
 */
public class PlanFactor {

    //险种代码
    private String planCode;
    // 费率是否与投保年龄相关
    private String permiumRateApplyingAge;
    //费率是否与投保性别相关
    private String permiumRateApplyGender;
    //费率是否与缴别相关
    private String permiumRatePaymentMode;
    //费率是否与缴费期限相关
    private String permiumRatePaymentPeriod;
    //费率是否与保单月份相关
    private String permiumRatePolicyMonth;
    //费率是否与领取年龄相关
    private String permiumRatePayoutAge;
    //费率是否与保险期限（月）相关
    private String permiumRateCoveragePeriod;
    //费率是否与保险期限（天）相关
    private String permiumRateCovPeriodDays;
    //费率是否与职业类别相关
    private String permiumRateOccupationGrade;
    //费率是否与保障档次相关
    private String permiumRateCoverageLevel;
    //现金价值是否与投保年龄相关
    private String cashValueApplyingAge;
    //现金价值是否与投保性别相关
    private String cashValueApplyingGender;
    //现金价值是否与缴费期限相关
    private String cashValuePaymentPeriod;
    //现金价值是否与保单月份相关
    private String cashValuePolicyMonth;
    //现金价值是否与领取年龄相关
    private String cashValuePayoutAge;
    //现金价值是否与领取选择相关
    private String cashValuePayoutOption;
    //现金价值是否与保险期限相关
    private String cashValueCoveragePeriod;
    //现金价值是否与缴别相关
    private String cashValuePaymentMode;
    //退保金是否与投保年龄相关
    private String surrenderApplyingAge;
    //退保金是否与投保性别相关
    private String surrenderApplyingGender;
    //退保金是否与缴费期限相关
    private String surrenderPaymentPeriod;
    //退保金是否与保单月份相关
    private String surrenderPolicyMonth;
    //退保金是否与领取年龄相关
    private String surrenderPayoutAge;
    //退保金是否与领取选择相关
    private String surrenderPayoutOption;
    //退保金是否与保险期限相关
    private String surrenderCoveragePeriod;
    //退保金是否与缴别相关
    private String surrenderPaymentMode;
    //费用率是否与缴费期限相关
    private String expenseRatePaymetPeriod;
    //费用率是否与保单月份相关
    private String expenseRatePolicyMonth;
    //费用率是否与缴别相关
    private String expenseRatePaymentMode;
    //费用率是否与保险期限相关
    private String expenseRateCoveragePeriod;
    //费率是否与投保份数相关
    private String premiumRatePolicyUnits;
    //费率是否与投保保额相关
    private String premiumRatePolicyAmount;
    //费率是否与社保相关(Y/N)
    private String socialSecurity;
    //是否与保单年度有关
    private String policyYear;

}
