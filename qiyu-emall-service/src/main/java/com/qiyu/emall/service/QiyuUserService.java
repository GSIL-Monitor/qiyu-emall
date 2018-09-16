package com.qiyu.emall.service;

import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.UserAddressVo;
import com.qiyu.emall.dto.MallUserAddressDto;
import com.qiyu.emall.dto.MallUserDto;
import com.qiyu.emall.entity.QiyuUser;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface QiyuUserService {


    ResponseData registerUser(MallUserDto mallUserDto);

    ResponseData getUserInfo(MallUserDto mallUserDto);

    ResponseData mallLogin(MallUserDto mallUserDto);

    QiyuUser getUserInfo(String jessonId);

    void saveUserAddress(QiyuUser qiyuUser, MallUserAddressDto addressDto)throws UnsupportedEncodingException;


    List<UserAddressVo> queryUserAddress(Integer userId);

}
