package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductSpec;

public interface QiyuProductSpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductSpec record);

    int insertSelective(QiyuProductSpec record);

    QiyuProductSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductSpec record);

    int updateByPrimaryKey(QiyuProductSpec record);
}