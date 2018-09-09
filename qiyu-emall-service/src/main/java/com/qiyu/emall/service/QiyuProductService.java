package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuProductVo;

public interface QiyuProductService {
    //根据商品id查询商品详情
    QiyuProductVo detail(Integer id);
}
