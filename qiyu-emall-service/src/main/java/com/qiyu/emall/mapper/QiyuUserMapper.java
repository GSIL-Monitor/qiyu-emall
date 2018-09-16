package com.qiyu.emall.mapper;

import com.qiyu.emall.dto.MallUserDto;
import com.qiyu.emall.entity.QiyuUser;

public interface QiyuUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyuUser record);

    int insertSelective(QiyuUser record);

    QiyuUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyuUser record);

    int updateByPrimaryKey(QiyuUser record);

    QiyuUser queryByOpenId(String openId);

    QiyuUser selectByUserPhone(String phone);
}