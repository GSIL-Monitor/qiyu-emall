package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductSpecStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QiyuProductSpecStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductSpecStock record);

    int insertSelective(QiyuProductSpecStock record);

    QiyuProductSpecStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductSpecStock record);

    int updateByPrimaryKey(QiyuProductSpecStock record);

    int deleteByProductId(Integer productId);

    int batchInsert(@Param("specStockList") List<QiyuProductSpecStock> specStockList);
}