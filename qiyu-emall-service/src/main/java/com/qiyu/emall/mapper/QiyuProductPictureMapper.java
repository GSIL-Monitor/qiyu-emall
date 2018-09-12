package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuProductPicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QiyuProductPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuProductPicture record);

    int insertSelective(QiyuProductPicture record);

    QiyuProductPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuProductPicture record);

    int updateByPrimaryKey(QiyuProductPicture record);

    int deleteByProductId(Integer productId);

    int batchInsert(@Param("productPictureList") List<QiyuProductPicture> productPictureList);
}