package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductSpec;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface QiyuProductSpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductSpec record);

    int insertSelective(QiyuProductSpec record);

    QiyuProductSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductSpec record);

    int updateByPrimaryKey(QiyuProductSpec record);

    int deleteByProductId(Integer productId);

    int batchInsert(@Param("productSpecSet") Set<QiyuProductSpec> productSpecSet);
}