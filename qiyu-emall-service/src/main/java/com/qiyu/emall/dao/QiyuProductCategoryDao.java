package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.entity.QiyuProductCategory;
import com.qiyu.emall.mapper.QiyuProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QiyuProductCategoryDao {

    @Autowired
    private QiyuProductCategoryMapper qiyuProductCategoryMapper;


    public int deleteByProductId(Integer qiyuProduct) {
        return qiyuProductCategoryMapper.deleteByProductId(qiyuProduct);
    }

    public int insert(QiyuProductCategory productCategory) {
        return qiyuProductCategoryMapper.insertSelective(productCategory);
    }
}