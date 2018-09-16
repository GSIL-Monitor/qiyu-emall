package com.qiyu.emall.dto;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by zengzhimin on 2017/7/18.
 */

public class BaseMallDto implements Serializable {
    private static final long serialVersionUID = 4713629933462862089L;
    /**
     * 用户登录信息
     */
    private String jsessionId;

    /**
     * 店铺ID
     */
    private Integer storeId;

    /**
     * 分页数据 每页大小
     */
    private Integer pageSize;

    /**
     * 分页数据 当前页 从1开始 不传或传0表示获取全部数据
     */
    private Integer currentPage;
    /**
     * 版本号 初始版本号v1.0.0
     */
    private String version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJsessionId() {
        return jsessionId;
    }

    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString(){
     return  toJson();
    }

}
