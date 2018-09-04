package com.qiyu.emall.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/1 下午5:49
 * Description: MD5加密算法工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/1      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class Md5EncryptUtils {
    private static final Logger LOG = LoggerFactory.getLogger(Md5EncryptUtils.class);

    /**
     * 获取MD5加密字符串
     *
     * @param buffer 需要加密的内容 默认全小写
     * @return String 加密之后的字符串
     */
    public static String getMessageDigestString(String buffer) {
        return getMessageDigestString(buffer.getBytes(), false);
    }

    /**
     * 获取MD5加密字符串
     *
     * @param buffer      需要加密的内容
     * @param isUppercase 返回值是否大写
     * @return String 加密之后的字符串
     */
    public static String getMessageDigestString(String buffer, boolean isUppercase) {
        return getMessageDigestString(buffer.getBytes(), isUppercase);
    }

    /**
     * 获取byte格式的MD5 byte字节
     *
     * @param buffer 需要加密的内容
     * @return byte 加密之后的byte
     */
    public static byte[] getMessageDigestByte(byte[] buffer) {
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            return mdTemp.digest();
        } catch (Exception e) {
            LOG.warn("--> getMessageDigestByte --> ", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取byte格式的 MD5 字符串
     *
     * @param buffer      需要加密的内容
     * @param isUppercase 是否大写
     * @return String
     */
    public static String getMessageDigestString(byte[] buffer, boolean isUppercase) {
        char hexLowercaseDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char hexUppercaseDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char hexDigits[] = isUppercase ? hexUppercaseDigits : hexLowercaseDigits;
        try {
            byte[] md = getMessageDigestByte(buffer);
            if (md != null) {
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (byte byte0 : md) {
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }
                return new String(str);
            }
        } catch (Exception e) {
            LOG.warn("--> getMessageDigestString --> ", e);
            e.printStackTrace();
        }
        return null;
    }
}
