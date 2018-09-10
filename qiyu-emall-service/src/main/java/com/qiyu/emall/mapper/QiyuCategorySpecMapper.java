package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuCategorySpec;

public interface QiyuCategorySpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuCategorySpec record);

    int insertSelective(QiyuCategorySpec record);

    QiyuCategorySpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuCategorySpec record);

    int updateByPrimaryKey(QiyuCategorySpec record);
}