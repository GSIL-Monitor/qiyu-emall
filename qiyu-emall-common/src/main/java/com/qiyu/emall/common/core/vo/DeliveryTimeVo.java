package com.qiyu.emall.common.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by shaozhou on 2017/8/4.
 */
@Data
public class DeliveryTimeVo implements Serializable {
    private Integer timeType;// 1 上午 2 下午 3 全天
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String typeVal;//上午 下午 全天
}
