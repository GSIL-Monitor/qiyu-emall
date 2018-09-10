package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProduct;

import java.util.List;

public interface QiyuProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProduct record);

    int insertSelective(QiyuProduct record);

    QiyuProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProduct record);

    int updateByPrimaryKey(QiyuProduct record);

    List<QiyuProduct> selectList();
}