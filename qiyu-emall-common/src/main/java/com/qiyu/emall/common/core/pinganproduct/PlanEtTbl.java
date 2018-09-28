package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 险种费用率表
 */
public class PlanEtTbl {

    //险种代码
    private String planCode;
    //缴费期限(月)
    private Integer premTerm;
    //缴别
    private String premType;
    //保单开始年度(月)
    private Integer strPolYr;
    //保单终止年度(月)
    private Integer endPolYr;
    //费用率
    private BigDecimal et;
    //保险期限(月)
    private Integer period;
}
