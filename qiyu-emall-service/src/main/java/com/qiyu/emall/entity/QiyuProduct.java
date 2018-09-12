package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

public class QiyuProduct extends BaseEntity {
    private Integer id;

    private String productName;

    private String productBar;

    private Integer isRecommend;

    private Integer status;

    private Integer categoryId;

    private Integer sort;

    private String description;

    private String picture;

    private Integer stock;

    private Integer pvNum;

    private Integer favNum;

    private Integer commentNum;

    private BigDecimal originalPrice;

    private BigDecimal currentPrice;
    /**
     * 商品图片列表
     */
    private List<String> pritureUrlList;
    /**
     * 商品规格库存数据
     */
    private QiyuProductSpecStock specStock;
    /**
     * 商品规格数据
     */
    private QiyuSpecification specification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPvNum() {
        return pvNum;
    }

    public void setPvNum(Integer pvNum) {
        this.pvNum = pvNum;
    }

    public Integer getFavNum() {
        return favNum;
    }

    public void setFavNum(Integer favNum) {
        this.favNum = favNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<String> getPritureUrlList() {
        return pritureUrlList;
    }

    public void setPritureUrlList(List<String> pritureUrlList) {
        this.pritureUrlList = pritureUrlList;
    }

    public QiyuProductSpecStock getSpecStock() {
        return specStock;
    }

    public void setSpecStock(QiyuProductSpecStock specStock) {
        this.specStock = specStock;
    }
}