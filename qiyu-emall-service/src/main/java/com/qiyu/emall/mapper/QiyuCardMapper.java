package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuCard;
import org.apache.ibatis.annotations.Param;

public interface QiyuCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuCard record);

    int insertSelective(QiyuCard record);

    QiyuCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuCard record);

    int updateByPrimaryKey(QiyuCard record);

    QiyuCard selectByNoPwd(@Param("cardNo") String cardNo,@Param("cardPwd") String cardPwd);
}