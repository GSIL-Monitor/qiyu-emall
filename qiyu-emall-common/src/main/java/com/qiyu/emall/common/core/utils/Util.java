package com.qiyu.emall.common.core.utils;

import com.google.gson.Gson;

/**
 * 基础工具类
 */
public class Util {

    /**
     * 将json字符串转换成object
     * @param jsonStr
     * @return
     */
    public static Object getObjectFromString(String jsonStr,Class t) {
        Object obj;
        try {
            Gson gson = new Gson();
            obj = gson.fromJson(jsonStr, t);
//            JSONObject jsonObject = JSONObject.fromObject(jsonStr);
//            obj = jsonObject.toBean(jsonObject, t);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return obj;
    }




}
