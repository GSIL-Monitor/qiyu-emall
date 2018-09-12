package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuSpecification;
import com.qiyu.emall.param.SpecificationSearchParam;

import java.util.List;

public interface QiyuSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuSpecification record);

    int insertSelective(QiyuSpecification record);

    QiyuSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuSpecification record);

    int updateByPrimaryKey(QiyuSpecification record);

    List<QiyuSpecification> searchSpecList(SpecificationSearchParam specPram);
}