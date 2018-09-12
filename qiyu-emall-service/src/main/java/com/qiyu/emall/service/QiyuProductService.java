package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.param.ProductSaveParam;

import java.util.List;

public interface QiyuProductService {
    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    QiyuProductVo detail(Integer id);
    /**
     * 查询商品列表
     * @return
     */
    List<QiyuProductVo> list();

    /**
     * 保存商品信息
     * @param param
     */
    void save(ProductSaveParam param);

    /**
     * 商品上下架
     * @param param
     */
    void updateStatus(ProductSaveParam param);
}
