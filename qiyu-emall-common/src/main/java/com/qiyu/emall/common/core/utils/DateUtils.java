package com.qiyu.emall.common.core.utils;

/**
 * Created by shaozhou on 2017/8/4.
 */
public class DateUtils {

    public static int dateType(String startTime,String endTime){ // 开始时间 5:08  结束时间 13:09
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        if(startHour<12 && endHour<12){
            return 1;
        }else if(startHour>12 && endHour>12){
            return 2;
        }else {
            return 3;
        }
    }
}
