package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductSpecStock;

public interface QiyuProductSpecStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductSpecStock record);

    int insertSelective(QiyuProductSpecStock record);

    QiyuProductSpecStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductSpecStock record);

    int updateByPrimaryKey(QiyuProductSpecStock record);
}