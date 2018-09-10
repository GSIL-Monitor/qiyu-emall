package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

/**
 * 商品分类与规格关联实体
 */
public class QiyuCategorySpec extends BaseEntity {
    private Integer id;

    private Integer categoryId;

    private Integer specId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

}