package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * @author SHAOZHOU687
 * @Title: ProductPlan
 * @ProjectName spring-framework
 * @Description: TODO
 * @date 2018/9/2111:33
 */
public class ProductPlan {
    private String planCode;
    private String planCoverageLevel;
    private BigDecimal planCoverageAmount;

    private String planType;


    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getPlanCoverageLevel() {
        return planCoverageLevel;
    }

    public void setPlanCoverageLevel(String planCoverageLevel) {
        this.planCoverageLevel = planCoverageLevel;
    }

    public BigDecimal getPlanCoverageAmount() {
        return planCoverageAmount;
    }

    public void setPlanCoverageAmount(BigDecimal planCoverageAmount) {
        this.planCoverageAmount = planCoverageAmount;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
