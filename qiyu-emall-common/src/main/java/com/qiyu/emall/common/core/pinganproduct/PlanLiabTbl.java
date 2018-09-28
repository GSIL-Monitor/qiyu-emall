package com.qiyu.emall.common.core.pinganproduct;

/**
 * 险种责任类型的相关性定义表
 */
public class PlanLiabTbl {
    // 险种代码
    private String planCode;
    // 责任类型代码
    private String liabType;
    //责任与保险期限相关否
    private String liabPeriod;
    //责任与缴费期限相关否
    private String liabPremTerm;
    //责任与缴别相关否
    private String liabPermType;
    //责任与性别相关否
    private String liabSex1;
    //责任与投保年龄相关否
    private String liabAge1;
    //责任与性别相关否(连身)
    private String liabSex2;
    //责任与投保年龄相关否(连身)
    private String liabAge2;
    //责任与领取年龄相关否
    private String liabPayAge;
    //责任与领取方式相关否
    private String liabPayType;
    //责任与地区级别相关否
    private String liabRegionLevel;
    //责任与给付档次相关否
    private String liabBenLevel;
    //责任与责任/年龄相关否
    private String liabPolAge;
    //责任与被保人类别相关否
    private String liabInsuredType;
    //是否180天内差额给付
    private String remainingSumOnly;
    //是否全残给付
    private String highDisableOnly;
    //最高额限制方法
    private String maxlimitMode;
}
