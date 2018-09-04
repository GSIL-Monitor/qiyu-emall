package com.qiyu.emall.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/14 下午5:25
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/14      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -6340855302427182139L;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
