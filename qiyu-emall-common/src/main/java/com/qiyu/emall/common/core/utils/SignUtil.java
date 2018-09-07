package com.qiyu.emall.common.core.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 生成签名类
 * Created by sujuan on 2017/7/7.
 */
public class SignUtil {


    public static String getMd5Sign(Object obj,String token) {
        Map<String,Object> params = objectToMapRemoveSign(obj);
        Collection<String> keyset = params.keySet();
        List<String> list = new ArrayList<>(keyset);
        //对key键值按字典升序排序
        Collections.sort(list);
        String sb = "";
        for (String aList : list) {
            if(StringUtils.isNotEmpty(String.valueOf(params.get(aList)))  && !"null".equals(String.valueOf(params.get(aList)))) {
                sb = sb.concat(aList).concat("=").concat(String.valueOf(params.get(aList))).concat("&");
            }
        }
        sb = sb.concat("token=").concat(token);
        //return Md5Util.GetMD5Code(sb);
        return null;
    }

    /**
     * 将bean将成map
     * @param obj bean对象
     * @return 转换的map值
     * @throws Exception
     */
    public static Map<String, Object> objectToMapRemoveSign(Object obj) {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if("sign".equals(field.getName())||"serialVersionUID".equals(field.getName()))
                    continue;
                if (value!=null&&value!="") {
                    map.put(field.getName(), field.get(obj));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static String getSignMd5(Object obj,String token){
        //生成签名
        Map<String, Object> map = new HashMap<String,Object>();
        try{
            map = null;
        }catch(Exception e){
            e.printStackTrace();
        }
        map.remove("sign");
        map.remove("nativePay");
        //版本号默认为1.0是系统处理,由于已有部分商户对接未传入版本号字段，故后续商户对接如需传入版本号字段必须为高于1.1版本
        if(map.get("version") != null && "1.0".equals(map.get("version"))){
            map.remove("version");
        }
        //String sign = TradePaySignUtil.getSignWithToken(map,token);
        return "";
    }


    public static void main(String args[]){
    }
}
