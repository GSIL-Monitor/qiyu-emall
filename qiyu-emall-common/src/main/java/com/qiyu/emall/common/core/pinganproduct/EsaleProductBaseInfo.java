package com.qiyu.emall.common.core.pinganproduct;

import java.util.List;

/**
 * @author SHAOZHOU687
 * @Title: EsaleProductBaseInfo
 * @ProjectName spring-framework
 * @Description: TODO
 * @date 2018/9/2110:39
 */
public class EsaleProductBaseInfo {

    private String productCode;

    private String productName;

    private String appType; // 团个单（G：团，P：个）

    //产品关联计划
    private List<ProductPlanCovLel> productPlanCovLelList;
    //邮件发送模板记录
    private List<EsaleEmailModel> emailModelList;
    //产品健康告知
    private CustomerNoteCode customerNoteCode;

}
