package com.qiyu.emall.common.core.vo;

public class QiyuSpecificationVo extends BaseVo {

    private Integer specId; // 规格id

    private String specName;

    private Integer specType;

    private String parentId;

    private Integer specLevel;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getSpecType() {
        return specType;
    }

    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSpecLevel() {
        return specLevel;
    }

    public void setSpecLevel(Integer specLevel) {
        this.specLevel = specLevel;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }
}