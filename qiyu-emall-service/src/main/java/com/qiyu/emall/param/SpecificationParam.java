package com.qiyu.emall.param;

import com.qiyu.emall.common.core.param.BaseParam;

import java.util.List;

public class SpecificationParam extends BaseParam {

    /**
     * 规格ids
     */
    private List<String> specIds;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 原价 两位小数 0.00
     */
    private String originalPrice;
    /**
     * 现价 两位小数 0.00
     */
    private String currentPrice;


    public List<String> getSpecIds() {
        return specIds;
    }

    public void setSpecIds(List<String> specIds) {
        this.specIds = specIds;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }


}
