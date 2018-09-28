package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;
import java.util.List;

public class PlanCoverageLevel {
    //险种编码
    private String planCode;
    //保障档次
    private String coverageLevel;
    //描述
    private String description;
    //医院ID
    private String hospitalId;
    //基本保额
    private BigDecimal baseCoverageAmount;

    // 险种总保额定义表
    private PlanClaimBaseCoverage baseCoverage;
    // 计划关联责任，责任明细数据
    private List<PlanClaimHealthLiab> healthLiabList;
    //险种计划服务关联表
    private List<ServiceItemDefineInfo> serviceItemDefineInfoList;
    //险种特殊责任保费保额比例
    private PlanSpecialPremRate specialPremRate;


}
