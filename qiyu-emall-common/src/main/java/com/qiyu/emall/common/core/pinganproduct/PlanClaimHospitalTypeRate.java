package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;

/**
 * 险种医院类型赔付比例定义
 */
public class PlanClaimHospitalTypeRate {

    //险种code
    private String planCode;
    //赔付标识号
    private String paymentId;
    //医院类型代码
    private String hospitalTypeCode;
    //目录内赔付比例
    private String directoryRate;
    //目录外不超过目录内比例
    private BigDecimal outNoMoreDirectoryRate;
    //目录外赔付比例
    private BigDecimal outDirectoryRate;
    //社保账单比例
    private BigDecimal socialInsuranceRate;
    //非社保账单比例
    private BigDecimal nonSocialInsuranceRate;
    //目录外费用不超过总费用比例
    private BigDecimal outNoMoreExpendRate;
    //优先级，数字大的优先级高
    private Integer priorityCode;
    //社保是否已先行赔付
    private String isSocialInsurancePaid;
}
