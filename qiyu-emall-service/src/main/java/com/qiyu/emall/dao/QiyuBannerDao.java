package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuBanner;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.mapper.QiyuBannerMapper;
import com.qiyu.emall.mapper.QiyuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuBannerDao {
    @Autowired
    private QiyuBannerMapper qiyuBannerMapper;

    public List<QiyuBanner> selectList() {
        return qiyuBannerMapper.selectList();
    }
}
