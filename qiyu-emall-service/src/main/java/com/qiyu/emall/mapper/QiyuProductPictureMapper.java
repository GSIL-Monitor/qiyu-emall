package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductPicture;

public interface QiyuProductPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductPicture record);

    int insertSelective(QiyuProductPicture record);

    QiyuProductPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductPicture record);

    int updateByPrimaryKey(QiyuProductPicture record);
}