package com.qiyu.emall.param;

import com.qiyu.emall.common.core.param.BaseParam;

import java.util.List;

public class ShopCartSaveParam extends BaseParam {

    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品规格库存表主键
     * 根据库存主键id查询库存相关信息
     */
    private Integer specStockId;
    /**
     * 购物车规格数量
     */
    private Integer specCount;

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
