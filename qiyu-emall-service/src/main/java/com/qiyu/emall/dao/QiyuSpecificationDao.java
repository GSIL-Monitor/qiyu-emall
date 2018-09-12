package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.entity.QiyuSpecification;
import com.qiyu.emall.mapper.QiyuProductMapper;
import com.qiyu.emall.mapper.QiyuSpecificationMapper;
import com.qiyu.emall.param.SpecificationSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuSpecificationDao {

    @Autowired
    private QiyuSpecificationMapper qiyuSpecificationMapper;


    public List<QiyuSpecification> searchSpecList(SpecificationSearchParam specPram) {
        return qiyuSpecificationMapper.searchSpecList(specPram);
    }
}
