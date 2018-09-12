package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductCategory;

public interface QiyuProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductCategory record);

    int insertSelective(QiyuProductCategory record);

    QiyuProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductCategory record);

    int updateByPrimaryKey(QiyuProductCategory record);

    int deleteByProductId(Integer qiyuProduct);
}