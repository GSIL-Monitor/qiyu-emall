package com.qiyu.emall.common.core.pinganproduct;

/**
 * 邮件发送模板记录表
 */
public class EsaleEmailModel {

    // 产品代码
    private String productCode;
    //模板类型 1邮件、2短信
    private String msgType;
    //发送目标类型 1客户、2渠道
    private String sourceType;
    //目标类型名称（客户、渠道）
    private String sourceName;
    //邮件模板
    private String emailModel;
}
