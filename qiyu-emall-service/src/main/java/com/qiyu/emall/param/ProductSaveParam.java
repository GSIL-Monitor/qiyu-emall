package com.qiyu.emall.param;

import com.qiyu.emall.common.core.param.BaseParam;

import java.util.List;

public class ProductSaveParam extends BaseParam {
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品条码
     */
    private String productBar;
    /**
     * 是否是推荐商品 0推荐 1不推荐
     */
    private Integer isRecommend;
    /**
     * 商品状态 0下架 1 上架
     */
    private Integer status;
    /**
     * 商品分类id
     */
    private Integer categoryId;
    /**
     * 规格list
     */
    private List<SpecificationParam> specParamList;
    /**
     * 商品封面图
     */
    private String picture;
    /**
     * 商品详情列表图
     */
    private List<String> pictureList;
    /**
     * 商品现价 0.00
     */
    private String currentPrice;
    /**
     * 商品原价 两位小数 0.00
     */
    private String originalPrice;
    /**
     * 商品描述
     */
    private String description;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBar() {
        return productBar;
    }

    public void setProductBar(String productBar) {
        this.productBar = productBar;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<SpecificationParam> getSpecParamList() {
        return specParamList;
    }

    public void setSpecParamList(List<SpecificationParam> specParamList) {
        this.specParamList = specParamList;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
