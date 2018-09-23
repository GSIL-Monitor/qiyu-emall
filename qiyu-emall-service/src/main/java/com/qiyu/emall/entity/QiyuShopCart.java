package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

public class QiyuShopCart extends BaseEntity {

    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer specStockId;

    private Integer specCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSpecStockId() {
        return specStockId;
    }

    public void setSpecStockId(Integer specStockId) {
        this.specStockId = specStockId;
    }

    public Integer getSpecCount() {
        return specCount;
    }

    public void setSpecCount(Integer specCount) {
        this.specCount = specCount;
    }

}