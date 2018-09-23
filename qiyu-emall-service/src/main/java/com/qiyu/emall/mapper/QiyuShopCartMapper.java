package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuShopCart;

public interface QiyuShopCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuShopCart record);

    int insertSelective(QiyuShopCart record);

    QiyuShopCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuShopCart record);

    int updateByPrimaryKey(QiyuShopCart record);
}