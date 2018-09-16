package com.qiyu.emall.mapper;

import com.qiyu.emall.entity.QyUserAddress;

import java.util.List;
import java.util.Map;

public interface QyUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QyUserAddress record);

    int insertSelective(QyUserAddress record);

    QyUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QyUserAddress record);

    int updateByPrimaryKey(QyUserAddress record);

    List<QyUserAddress> queryByMap(Map<String,Object> paramMap);
}