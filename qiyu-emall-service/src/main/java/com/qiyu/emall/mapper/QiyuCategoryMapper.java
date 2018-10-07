package com.qiyu.emall.mapper;

import com.qiyu.emall.common.core.vo.QiyuCategoryVo;
import com.qiyu.emall.entity.QiyuCategory;
import com.qiyu.emall.param.CategorySearchParam;

import java.util.List;

public interface QiyuCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuCategory record);

    int insertSelective(QiyuCategory record);

    QiyuCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuCategory record);

    int updateByPrimaryKey(QiyuCategory record);

    List<QiyuCategory> list(CategorySearchParam searchParam);
}