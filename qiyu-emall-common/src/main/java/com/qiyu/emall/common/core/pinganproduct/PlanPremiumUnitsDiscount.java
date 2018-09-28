package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 份数保费折扣定义表
 */
public class PlanPremiumUnitsDiscount {

    // 险种代码
    private String planCode;
    //起始份数
    private Integer startUnits;
    //截止份数
    private Integer endUnits;
    //保费折扣率
    private BigDecimal discount;
}
