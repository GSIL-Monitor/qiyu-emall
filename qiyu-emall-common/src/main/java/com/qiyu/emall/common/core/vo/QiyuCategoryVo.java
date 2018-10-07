package com.qiyu.emall.common.core.vo;

import com.qiyu.emall.common.core.entity.BaseEntity;

public class QiyuCategoryVo extends  BaseVo {
    //分类id
    private Integer categoryId;
    //分类名称
    private String categoryName;
    //分类类型
    private String categoryType;
    //父分类id
    private Integer parentId;
    //分类
    private Integer level;
    //分类编号
    private String categoryNo;
    //分类图标
    private String icon;
    //状态(0:禁用 1:启用)
    private Byte status;
    //排序(倒序排序,默认值0)
    private Integer sort;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}