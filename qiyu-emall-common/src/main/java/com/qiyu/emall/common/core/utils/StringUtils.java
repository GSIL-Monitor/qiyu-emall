package com.qiyu.emall.common.core.utils;

import java.util.List;
import java.util.Map;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/1 下午5:36
 * Description: 字符串工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/1      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class StringUtils {
    /**
     * 私有构造方法,将该工具类设为单例模式.
     */
    private StringUtils() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串内容
     * @return Boolean
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 需要怕丢的对象
     * @return Boolean
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return "".equals(((String) obj).trim());
        }
        return !(obj instanceof Number) ? false : false;
    }

    /**
     * 判断数组对象是否为空
     *
     * @param array 数组对象
     * @return Boolean
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || 0 == array.length;
    }

    /**
     * 判断集合对象是否为空
     *
     * @param list 集合对象
     * @return Boolean
     */
    public static boolean isEmpty(List<?> list) {
        return null == list || list.isEmpty();
    }

    /**
     * 判断Map集合是否为空
     *
     * @param maps Map集合对象
     * @return Boolean
     */
    public static boolean isEmpty(Map<?, ?> maps) {
        return null == maps || maps.isEmpty();
    }
}
