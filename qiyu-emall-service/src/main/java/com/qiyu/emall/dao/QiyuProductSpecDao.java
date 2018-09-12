package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.entity.QiyuProductSpec;
import com.qiyu.emall.mapper.QiyuProductSpecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class QiyuProductSpecDao {

    @Autowired
    private QiyuProductSpecMapper qiyuProductSpecMapper;


    public int deleteByProductId(Integer productId) {
        return qiyuProductSpecMapper.deleteByProductId(productId);
    }

    public int batchInsert(Set<QiyuProductSpec> productSpecSet) {
        return qiyuProductSpecMapper.batchInsert(productSpecSet);
    }
}