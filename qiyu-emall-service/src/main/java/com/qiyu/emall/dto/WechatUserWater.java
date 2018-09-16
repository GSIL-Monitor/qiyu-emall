package com.qiyu.emall.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by zengzhimin on 2017/8/1.
 */

public class WechatUserWater implements Serializable {
    private static final long serialVersionUID = -5376941323445656692L;
    /**
     * 小程序appId
     */
    @SerializedName("appid")
    private String appId;

    private long  timestamp;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
