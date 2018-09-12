package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.entity.QiyuProductPicture;
import com.qiyu.emall.mapper.QiyuProductMapper;
import com.qiyu.emall.mapper.QiyuProductPictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuProductPictureDao {

    @Autowired
    private QiyuProductPictureMapper qiyuProductPictureMapper;


    public int deleteByProductId(Integer productId) {
        return qiyuProductPictureMapper.deleteByProductId(productId);
    }

    public int batchInsert(List<QiyuProductPicture> pictureList) {
        return qiyuProductPictureMapper.batchInsert(pictureList);
    }
}
