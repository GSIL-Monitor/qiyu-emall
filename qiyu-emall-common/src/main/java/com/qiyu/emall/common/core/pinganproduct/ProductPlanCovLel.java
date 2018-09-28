package com.qiyu.emall.common.core.pinganproduct;

import java.util.List;

/**
 * @author SHAOZHOU687
 * @Title: ProductPlanCovLel
 * @ProjectName spring-framework
 * @Description: TODO
 * @date 2018/9/2110:43
 */
public class ProductPlanCovLel {

    private String coverageLevel; //计划
    private Integer minApplicantAge; //投保人最小年龄
    private Integer minInsuredAge;//被保人最小年龄
    private Integer maxInsuredAge;//被保人最大年龄
    private String isApplyAgainLimit;// Y/N. Y:有重复投保限制。N：无重复投保限制
    private String isCoverageAmountLimit;// Y/N.Y:有保额限制。N：无保额限制
    private Integer minCoverageAmount;// 最小保额
    private Integer maxCoverageAmount; // 最大保额
    private Integer limitTimes; // 限制次数
    private Integer coolingOffPeriodDays;// 犹豫天数
    private String bakCoveragePremiumTypeCode;// 退费规则
    private String renewalFlowType; // 续保流程
    private String isValid;// 是否有效，default"Y"
    // 产品险种计划
    private List<ProductPlan> productPlanList;


    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public List<ProductPlan> getProductPlanList() {
        return productPlanList;
    }

    public void setProductPlanList(List<ProductPlan> productPlanList) {
        this.productPlanList = productPlanList;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public Integer getMinApplicantAge() {
        return minApplicantAge;
    }

    public void setMinApplicantAge(Integer minApplicantAge) {
        this.minApplicantAge = minApplicantAge;
    }

    public Integer getMinInsuredAge() {
        return minInsuredAge;
    }

    public void setMinInsuredAge(Integer minInsuredAge) {
        this.minInsuredAge = minInsuredAge;
    }

    public Integer getMaxInsuredAge() {
        return maxInsuredAge;
    }

    public void setMaxInsuredAge(Integer maxInsuredAge) {
        this.maxInsuredAge = maxInsuredAge;
    }

    public String getIsApplyAgainLimit() {
        return isApplyAgainLimit;
    }

    public void setIsApplyAgainLimit(String isApplyAgainLimit) {
        this.isApplyAgainLimit = isApplyAgainLimit;
    }

    public String getIsCoverageAmountLimit() {
        return isCoverageAmountLimit;
    }

    public void setIsCoverageAmountLimit(String isCoverageAmountLimit) {
        this.isCoverageAmountLimit = isCoverageAmountLimit;
    }

    public Integer getMinCoverageAmount() {
        return minCoverageAmount;
    }

    public void setMinCoverageAmount(Integer minCoverageAmount) {
        this.minCoverageAmount = minCoverageAmount;
    }

    public Integer getMaxCoverageAmount() {
        return maxCoverageAmount;
    }

    public void setMaxCoverageAmount(Integer maxCoverageAmount) {
        this.maxCoverageAmount = maxCoverageAmount;
    }

    public Integer getLimitTimes() {
        return limitTimes;
    }

    public void setLimitTimes(Integer limitTimes) {
        this.limitTimes = limitTimes;
    }

    public Integer getCoolingOffPeriodDays() {
        return coolingOffPeriodDays;
    }

    public void setCoolingOffPeriodDays(Integer coolingOffPeriodDays) {
        this.coolingOffPeriodDays = coolingOffPeriodDays;
    }

    public String getBakCoveragePremiumTypeCode() {
        return bakCoveragePremiumTypeCode;
    }

    public void setBakCoveragePremiumTypeCode(String bakCoveragePremiumTypeCode) {
        this.bakCoveragePremiumTypeCode = bakCoveragePremiumTypeCode;
    }

    public String getRenewalFlowType() {
        return renewalFlowType;
    }

    public void setRenewalFlowType(String renewalFlowType) {
        this.renewalFlowType = renewalFlowType;
    }
}
