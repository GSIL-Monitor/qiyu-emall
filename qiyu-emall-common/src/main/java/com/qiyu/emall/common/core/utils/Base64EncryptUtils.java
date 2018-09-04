package com.qiyu.emall.common.core.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/1 下午6:08
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/1      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class Base64EncryptUtils {
    /**
     * 用Base64算法进行加密
     *
     * @param str 需要加密的字符串
     * @return Base64加密后的结果
     */
    public static String encodeBase64String(String str) {
        return new BASE64Encoder().encode(str.getBytes());
    }

    /**
     * 用Base64算法进行解密
     *
     * @param str 需要解密的字符串
     * @return Base64加密后的结果
     * @throws IOException 异常
     */
    public static String decodeBase64String(String str) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(str));
    }
}
