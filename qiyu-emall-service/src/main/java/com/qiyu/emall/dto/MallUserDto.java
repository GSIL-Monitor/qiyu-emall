package com.qiyu.emall.dto;

import java.util.Date;

/**
 * Created by zengzhimin on 2017/7/17.
 */

public class MallUserDto extends BaseMallDto{
    private static final long serialVersionUID = -2958899602318124472L;

    private Integer id;

    /**
     * 小程序登录返回的code
     */
    private String code;

    /**
     * 来源(0:小程序 1会员平台)
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

    private Integer queryStatus;//0
    /**
     * openid
     */
    private String openId;

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

    private Integer merchantId;

    private String appid;

    /**
     * 动态短信验证码
     */
    private String smsCode;

    /**
     * 验券小程序登录的token
     */

    private String tokenId;

    private Integer type;//空或者0 为小程序注册 1为验券小程序注册

    //0非合伙人 1：合伙人
    private Integer isPartner;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogisticsPhone() {
        return logisticsPhone;
    }

    public void setLogisticsPhone(String logisticsPhone) {
        this.logisticsPhone = logisticsPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(Integer queryStatus) {
        this.queryStatus = queryStatus;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(Integer isPartner) {
        this.isPartner = isPartner;
    }
}
