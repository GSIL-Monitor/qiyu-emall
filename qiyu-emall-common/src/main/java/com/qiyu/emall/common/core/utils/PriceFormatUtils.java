package com.qiyu.emall.common.core.utils;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/18 下午3:11
 * Description: 价格金额格式化输出类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/18      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PriceFormatUtils {
    /**
     * 格式化金额显示
     *
     * @param price 需要格式化显示的价格 单位元
     * @return 价格字符串
     */
    public static String getPriceDisplay(BigDecimal price) {
        return String.format(Locale.CHINA, "%.02f", price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    /**
     * 获取保留两位小数之后四舍五入的价格
     *
     * @param price 价格 单位元
     * @return 价格字符串
     */
    public static String getPriceDisplay(double price) {
        return getPriceDisplay(new BigDecimal(price));
    }

    /**
     * 获取保留两位小数之后四舍五入的价格
     *
     * @param price 价格 单位分
     * @return 价格字符串
     */
    public static String getPriceDisplay(long price) {
        return getPriceDisplay(price * 0.01);
    }

}
