package com.qiyu.emall.common.core.utils;

import java.util.List;
/**
 * Created by Ventures on 2015/12/17.
 * 集合工具类
 */
public class CollectionUtil {

    /**
     * List转换String
     *
     * @param list
     *            :需要转换的List
     * @return String转换后的字符串
     */
    public static String ListToStringAll(List<?> list, String decollator) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (list != null && list.size() > 0) {
            for (Object aList : list) {
                if (aList == null || aList == "") {
                    continue;
                }
                if (flag)
                    sb.append(decollator);
                else
                    flag = true;
                // 如果值是list类型则调用自己
                if (aList instanceof List) {
                    sb.append(ListToStringAll((List<?>) aList, decollator));
                }
//                else if (list.get(i) instanceof Map) {
//                    sb.append(MapToString((Map<?, ?>) list.get(i)));
//                }
                else {
                    sb.append(aList);
                }
            }
        }
        return sb.toString();
    }

    /**
     * list转String
     * @param stringList
     * @param decollator :分隔符
     * @return
     */
    public static String listToString(List<String> stringList, String decollator ){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(decollator);
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

}
