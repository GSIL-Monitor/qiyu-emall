package com.qiyu.emall.common.core.pinganproduct;

/**
 * 险种区域自定义数据
 */
public class PlanClaimAreaDefine {
    //险种编码
    private String planCode;
    //区域自定义标识
    private String areaDefineId;
    //描述
    private String description;
    //是否为包含方式 Y包含 N排除
    private String isInclusive;
    //英文名称
    private String englishName;

    /**
     * detail字段
     */
    //区域ID
    private String areaId;
    //国家与地区ID
    private String disTrictId;
}
