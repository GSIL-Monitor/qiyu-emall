package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuContent;

import java.util.List;

public interface QiyuContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuContent record);

    int insertSelective(QiyuContent record);

    QiyuContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuContent record);

    int updateByPrimaryKeyWithBLOBs(QiyuContent record);

    int updateByPrimaryKey(QiyuContent record);

    List<QiyuContent> selectList();
}