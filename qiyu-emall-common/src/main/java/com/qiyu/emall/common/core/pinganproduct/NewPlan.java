package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author SHAOZHOU687
 * @Title: NewPlan
 * @ProjectName spring-framework
 * @Description: TODO
 * @date 2018/9/2114:52
 */
public class NewPlan {
    //险种代码
    private String planCode;
    //险种名称
    private String planName;
    //险种财务代码
    private String planFinanceCode;
    //简称
    private String abbrName;
    //起售日期
    private Date startDate;
    //契约止售日期
    private Date newBusinessEndDate;
    //保全止售日期
    private Date policyOwnerServiceEndDate;
    //主附约类型代码
    private String riderTypeCode;
    //险种通用分类代码
    private String planCommonTypeCode;
    //险种性质分类代码
    private String planAttributeTypeCode;
    //险种保险期限类型代码
    private String planPeriodTypeCode;
    //年龄计算方法代码
    private String ageCalculationMethodCode;
    //性别代码
    private String genderCode;
    //保障档次类型代码
    private String coverageLevelTypeCode;
    //是否需要销售资格
    private String needSellingQualification;
    //最低折扣比
    private String minDiscount;
    //是否账户型险种
    private String isAccountPlan;
    //是否组合险
    private String isCombinedPlan;
    //组合险系列代码
    private String combinedPlanSeriesCode;
    //满期年龄
    private Integer maturityAge;
    //最小投保年龄
    private Integer minApplyingAge;
    //最大投保年龄
    private Integer maxApplyingAge;
    //销售单位代码
    private String saleUnitCode;
    //基本保额
    private Integer baseCoverageAmount;
    //最小承保保额
    private Integer minCoverageAmount;
    //最大承保保额
    private Integer maxCoverageAmount;
    //最小承保份数
    private Integer minCoverageUnits;
    //最大承保份数
    private Integer maxCoverageUnits;
    //保险期限(月)限定
    private String coveragePeriodMonthSet;
    //保险期限(天)限定
    private String coveragePeriodDaySet;
    //缴别限定
    private String paymentModeSet;
    //缴费期限限定
    private String paymentPeriodSet;
    //保费余额类型代码
    private String premiumBalanceTypeCode;
    //是否允许集体帐户缴费
    private String permitCollectiveAccPayment;
    //是否允许零保费
    private String permitZeroPermium;
    //记名方式代码
    private String nominateTypeCode;
    //是否允许外币投保
    private String permitForeignCurrency;
    //是否允许加保
    private String permitAddCoverAge;
    //加保补费计算方法
    private String addCoveragePermiumTypeCode;
    //是否允许减保
    private String permitPartialSurrender;
    //是否允许退保
    private String permitSurrender;
    //退保选择权代码
    private String surrenderOptionCode;
    //允否自动核保
    private String permitAutoUnderWriting;
    //普通管理费收取方式限定
    private String generalManageFeeChargeSet;
    //是否储金保险
    private String isDeposit;
    //是否平准保费
    private String isLevelPremium;
    //领取年龄限定
    private String payoutAgeSet;
    //领取日期方式限定
    private String payoutDateTypeSet;
    //即期领取延期月份
    private Integer immediatePayoutStartMonth;
    //供款类型限定
    private String supplyTypeSet;
    //保费计算方向限定
    private String premCalculateDirectionSet;
    //分红选择权限定
    private String dividendOptionSet;
    //是否有减保选择权
    private String permitWithdrawalOption;
    //减保选择权每次最大比例
    private BigDecimal maxWithdrawalPercentage;
    //最大减保选择权次数
    private Integer maxWithdrawalTimes;
    //犹豫天数
    private Integer coolingOffPeriodDays;
    //宽限天数
    private Integer gracePeriodDays;
    //投保追溯天数
    private Integer applyingBackwardDays;
    //标准特别约定
    private String standardSpecialAgreement;
    //核保分类代码
    private String underWritingTypeCode;
    //创建用户
    private String createdUser;
    //创建日期
    private Date createdDate;
    //最后修改用户
    private String lastModifiedUser;
    //最后修改日期
    private Date lastModifiedDate;
    //是否投资合同
    private String isInvestContract;
    //公司标记代码
    private String corporationFlagCode;
    //是否家庭险
    private String isFamily;
    //险种保障类型
    private String planReserveTypeCode;
    //团体产品还是个人产品
    private String appType;
    //险种财务期限代码
    private String planFinancialPeriodCode;
    //保额计算方式代码
    private String covAmtCalModeCode;
    //是否创建账户
    private String buildAccountFlag;
    //险种英文简称
    private String englishAbbr;
    //保证续保年期
    private Integer guaranteedRenewalPeriod;
    //是否服务合同（Y/N，默认为N）
    private String isServiceContract;
    //合同类型
    private String contractType;
    //英文名称
    private String englishName;
    //允许寿险销售标示
    private String permitSaleLifeinsurance;
    //是否为医疗保险险种
    private String isMedicalInsurance;
    //显示顺序
    private Integer sortOrder;

    //险种保障档次数据
    private List<PlanCoverageLevel> planCoverageLevelList;
    //险种区域自定义数据
    private List<PlanClaimAreaDefine> areaDefineList;
    //险种等待期定义
    private List<PlanCliamWaitPeriod> waitPeriodList;
    //险种医院类型赔付比例定义
    private List<PlanClaimHospitalTypeRate> hospitalTypeRateList;
    // 险种指定天数区间的赔付比例定义
    private List<PlanClaimTimeIntervalRate> timeIntervalRateList;
    //险种免赔额定义
    private List<PlanClaimDeductAmount> deductAmountList;
    // 险种的标准保费折标系数
    private StdPremRateTbl stdPremRate;


    //险种费用率
    private PlanEtTbl etTbl;
    //险种保费折算
    private ModalFactor modalFactor;
    //险种份数保费折扣表
    private List<PlanPremiumUnitsDiscount> unitsDiscountList;
    //险种折扣表
    private List<PlanDiscount> planDiscountList;
    //险种各类相关性定义
    private PlanFactor planFactor;
    //险种责任类型的相关性定义
    private PlanLiabTbl planLiabTbl;

    //险种理赔费用和治疗类型定义
    private List<LiabSubitemFeeType> subitemFeeTypeList;

    //采用新理算逻辑标志(Y:新逻辑 N:旧逻辑)
    private String useNewLogic;
    //目录内外计算公式
    private String directoryCalculateFormula;
}
