package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuShopCartVo;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.param.ShopCartSearchParam;

import java.util.List;

public interface QiyuShopCartService {
    /**
     * 根据购物车查询购物车详情
     * @param id
     * @return
     */
    QiyuShopCartVo detail(Integer id);
    /**
     * 查询购物车列表
     * @return
     * @param param
     */
    List<QiyuShopCartVo> list(ShopCartSearchParam param);

    /**
     * 加入购物车
     * @param param
     */
    void save(ProductSaveParam param);

    /**
     * 删除购物车的商品
     * @param shopCartId
     * @return
     */
    int delete(int shopCartId);
}
