package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 险种折扣表
 */
public class PlanDiscount {

    //险种代码
    private String planCode;
    //起始投保人数（闭区间）
    private Integer startAppPsns;
    //截止投保人数（闭区间）
    private Integer endAppPsns;
    //折扣
    private BigDecimal discount;
}
