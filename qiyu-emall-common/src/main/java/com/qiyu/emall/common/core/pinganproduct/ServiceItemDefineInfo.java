package com.qiyu.emall.common.core.pinganproduct;

/**
 * 险种服务项目和次数定义表
 */
public class ServiceItemDefineInfo {
    //服务项目号
    private String serviceItemCode;
    //是否免费
    private String isFree;
    //最大服务次数
    private Integer maxServiceTimes;
    //帐户类型代码(外)
    private String accountTypeCode;

    //关联的服务实体
    private ServiceItemInfo serviceItemInfo;

}
