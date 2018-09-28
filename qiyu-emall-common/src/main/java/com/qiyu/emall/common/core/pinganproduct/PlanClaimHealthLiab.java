package com.qiyu.emall.common.core.pinganproduct;

import java.util.List;

/**
 * 健康责任定义
 */
public class PlanClaimHealthLiab {
    // 责任编码
    private String liabItem;
    // 责任明细代码
    private String liabSubItem;
    //保障区域（关联）
    private String areaDefineId;
    //等待期（关联）
    private String waitPeriodId;
    //延长期
    private Integer coverageExtension;
    //责任赔付比例
    private String liabPaymentRate;
    //医院赔付（关联非外键plan_claim_hospital_type_rate）
    private String hospitalPaymentId;
    //预授权（关联非外键plan_claim_pre_authorized_rate）
    private String preAuthPaymentId;
    //免赔额（关联）
    private String deductPaymentId;
    //指定区间赔付（关联非外键plan_claim_time_interval_rate）
    private String timeIntervalPaymentId;
    //总保额（关联）
    private String baseCoverageId;
    //可选责任是否支付
    private String isPaid;

    //责任关联分项保额数据
    private List<PlanClaimShareCoverageDef> shareCoverageDefList;
}
