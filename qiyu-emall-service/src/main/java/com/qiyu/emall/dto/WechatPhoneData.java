package com.qiyu.emall.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zengzhimin on 2017/7/18.
 */

public class WechatPhoneData implements Serializable {
    private static final long serialVersionUID = -5376941323445656692L;


    private String phoneNumber;

    private String purePhoneNumber;

    private String countryCode;
    /**
     * 数据水印
     */
    private WechatUserWater watermark;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurePhoneNumber() {
        return purePhoneNumber;
    }

    public void setPurePhoneNumber(String purePhoneNumber) {
        this.purePhoneNumber = purePhoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public WechatUserWater getWatermark() {
        return watermark;
    }

    public void setWatermark(WechatUserWater watermark) {
        this.watermark = watermark;
    }
}
