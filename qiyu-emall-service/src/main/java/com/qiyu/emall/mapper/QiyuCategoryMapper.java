package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuCategory;

public interface QiyuCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuCategory record);

    int insertSelective(QiyuCategory record);

    QiyuCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuCategory record);

    int updateByPrimaryKey(QiyuCategory record);
}