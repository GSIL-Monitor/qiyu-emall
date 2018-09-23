package com.qiyu.emall.common.core.vo;

public class QiyuShopCartVo extends  BaseVo {

    private Integer shopCartId;
    private Integer productId;
    private String specCode;
    private Integer specCount;

    public Integer getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Integer shopCartId) {
        this.shopCartId = shopCartId;
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

    public Integer getSpecCount() {
        return specCount;
    }

    public void setSpecCount(Integer specCount) {
        this.specCount = specCount;
    }

}
