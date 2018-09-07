package com.qiyu.emall.common.core.utils;

import java.util.Random;
import java.util.UUID;

/**
 *
 * Created by sj on 2016/9/22.
 */
public class UUIDutil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 生成6位随机数
     */
    public static String generateRandomNum() {
        String chars = "0123456789";
        int num = 6;
        char[] rands = new char[num];
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return String.valueOf(rands);
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
