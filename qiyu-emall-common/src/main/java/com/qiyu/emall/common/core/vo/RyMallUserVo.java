package com.qiyu.emall.common.core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * Created by zengzhimin on 2017/7/17.
 */
@Data
@ToString(callSuper = true)
public class RyMallUserVo{
    private static final long serialVersionUID = -2958899602318124472L;

    private Integer id;
    /**
     * 小程序登录返回的code
     */
    private String code;

    /**
     * 来源(0:小程序)
     */
    private Integer source;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 配送常用手机号码
     */
    private String logisticsPhone;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private Date registerAt;

    /**
     * 注册IP
     */
    private String registerIp;

    /**
     * 登录时间
     */
    private Date loginAt;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 账户状态(0:限制登录,-1:禁用,1:正常,2:限制功能)
     */
    private Integer status;

    /**
     * openid
     */
    private String openId;
    /**
     * unionId
     */
    private String unionId;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 小程序登录返回的加密用户信息
     */
    private String encryptedData;
    /**
     * aes解密串
     */
    private String iv ;
    /**
     * 会员等级
     */
    private String level;
    /**
     * 会员性别 0男 1 女
     */
    private Integer gender;
    /**
     * 会员类型 0 新会员 1老会员
     */
    private Integer memberType;

    private Date createAt;
    private Date updateAt;
    private String createUser;
    private String updateUser;
    private String remark;
    private Integer queryStatus;
}
