package com.qiyu.emall.common.core.vo;

public class QiyuBannerVo extends BaseVo {
    private Integer bannerId;

    //业务类型 1商品,2文章
    private Integer type;
    //业务id
    private Integer businessId;
    // banner名称
    private String name;
    //banner图片
    private String picture;

    private String url;
    //  banner 状态0 显示 1隐藏 2删除
    private Integer status;
    // 排序,值越大越靠前
    private Integer sort;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }
}