package com.qiyu.emall.common.core.pinganproduct;

/**
 * 险种共用保额
 */
public class PlanClaimShareCoverageDef {

    // 共用标识
    private String shareCoverageId;
    //共用说明
    private String description;
    //共用限额
    private String limitAmount;
    //共用类型 (01天数 02次数 03保额)
    private String shareTypeCode;
    //单位 (01年 02次 03终身 04天)
    private String shareUnit;
    //次定义类型代码
    private String limitTypeCode;
    //责任类型
    private String liabTypeCode;
}
