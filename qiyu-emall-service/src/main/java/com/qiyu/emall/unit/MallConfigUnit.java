package com.qiyu.emall.unit;

/**
 * Created by zengzhimin on 2017/7/17.
 */
public class MallConfigUnit {

    /**
     * 小程序应用id
     */
    private String clientAppId;
    /**
     * 小程序秘钥
     */
    private String clienAppSecret;
    private String clientMchId;
    private String clientKey;


    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    public String getClienAppSecret() {
        return clienAppSecret;
    }

    public void setClienAppSecret(String clienAppSecret) {
        this.clienAppSecret = clienAppSecret;
    }

    public String getClientMchId() {
        return clientMchId;
    }

    public void setClientMchId(String clientMchId) {
        this.clientMchId = clientMchId;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }


}
