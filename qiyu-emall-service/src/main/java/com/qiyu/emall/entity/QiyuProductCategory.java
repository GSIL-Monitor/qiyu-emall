package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

public class QiyuProductCategory extends BaseEntity {
    private Integer id;

    private Integer categoryId;

    private Integer productId;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}