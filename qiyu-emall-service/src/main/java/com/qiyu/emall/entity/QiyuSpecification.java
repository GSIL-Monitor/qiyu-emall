package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

public class QiyuSpecification extends BaseEntity {
    private Integer id;

    private String specName;

    private Integer specType;

    private String parentId;

    private Integer specLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}