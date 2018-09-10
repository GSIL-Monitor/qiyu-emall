package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

public class QiyuProductPicture extends BaseEntity {
    private Integer id;

    private Integer productId;

    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}