package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格库存实体
 */
public class QiyuProductSpecStock extends BaseEntity {
    private Integer id;

    private Integer productId;

    private String specCode; // 规格id的集合   ,1,2,3,4,5, 前后都有逗号

    private Integer stock;

    private Integer initStock;

    private BigDecimal originalPrice;

    private BigDecimal currentPrice;

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

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getInitStock() {
        return initStock;
    }

    public void setInitStock(Integer initStock) {
        this.initStock = initStock;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

}