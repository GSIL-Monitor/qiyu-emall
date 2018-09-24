package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QiyuUserAcc;
import org.apache.ibatis.annotations.Param;

public interface QiyuUserAccMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuUserAcc record);

    int insertSelective(QiyuUserAcc record);

    QiyuUserAcc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuUserAcc record);

    int updateByPrimaryKey(QiyuUserAcc record);

    QiyuUserAcc selectByUserId(@Param("userId") Integer userId);
}