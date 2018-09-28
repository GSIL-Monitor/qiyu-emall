package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 指定天数区间的赔付比例定义
 */
public class PlanClaimTimeIntervalRate {

    //险种编码
    private String planCode;
    //赔付标识号
    private String paymentId;
    //开始日
    private Integer startDay;
    //结束日
    private Integer endDay;
    //赔付比例
    private BigDecimal payentRate;
    //行动类型编码
    private String actionTypeCode;
}
