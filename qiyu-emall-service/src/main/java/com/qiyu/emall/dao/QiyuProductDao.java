package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.mapper.QiyuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QiyuProductDao {
    @Autowired
    private QiyuProductMapper qiyuProductMapper;

    public QiyuProduct detail(Integer id) {
        return qiyuProductMapper.selectByPrimaryKey(id);
    }
}
