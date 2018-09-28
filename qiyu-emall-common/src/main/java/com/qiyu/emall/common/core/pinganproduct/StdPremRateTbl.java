package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 险种的标准保费折标系数表
 */
public class StdPremRateTbl {
    //险种代码
    private String planCode;
    //起始缴费年限
    private Integer strPremTerm;
    //截止缴费年限
    private Integer endPermTerm;
    //起始保单年度
    private Integer strPolYr;
    //截止保单年度
    private Integer endPolYr;
    //投保类型
    private String appType;
    //缴费方式
    private String premType;
    //折标比例
    private BigDecimal premRate;
}
