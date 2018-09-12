package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProductSpecStock;
import com.qiyu.emall.mapper.QiyuProductSpecMapper;
import com.qiyu.emall.mapper.QiyuProductSpecStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuProductSpecStockDao {

    @Autowired
    private QiyuProductSpecStockMapper qiyuProductSpecStockMapper;


    public int deleteByProductId(Integer productId) {
        return qiyuProductSpecStockMapper.deleteByProductId(productId);
    }

    public int batchInsert(List<QiyuProductSpecStock> specStockList) {
        return qiyuProductSpecStockMapper.batchInsert(specStockList);
    }
}