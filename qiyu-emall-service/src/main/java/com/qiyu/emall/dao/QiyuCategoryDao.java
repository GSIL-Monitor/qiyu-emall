package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.mapper.QiyuCategoryMapper;
import com.qiyu.emall.mapper.QiyuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuCategoryDao {

    @Autowired
    private QiyuCategoryMapper qiyuCategoryMapper;


}
