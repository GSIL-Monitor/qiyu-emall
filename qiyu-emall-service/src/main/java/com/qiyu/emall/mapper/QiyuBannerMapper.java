package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuBanner;

import java.util.List;

public interface QiyuBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuBanner record);

    int insertSelective(QiyuBanner record);

    QiyuBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuBanner record);

    int updateByPrimaryKey(QiyuBanner record);

    List<QiyuBanner> selectList();
}