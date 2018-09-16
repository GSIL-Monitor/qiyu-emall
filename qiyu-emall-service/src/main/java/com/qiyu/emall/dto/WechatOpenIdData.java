package com.qiyu.emall.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by zengzhimin on 2017/7/18.
 */

public class WechatOpenIdData implements Serializable {
    private static final long serialVersionUID = 915175891629692156L;
    /**
     * 用户OpenID
     */
    private String openid;

    /**
     * 接口sessionKey
     */
    @SerializedName("session_key")
    private String sessionKey;

    /**
     * 接口错误码
     */
    private String errcode;

    /**
     * 接口错误消息
     */
    private String errmsg;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
