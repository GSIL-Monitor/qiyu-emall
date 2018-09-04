package com.qiyu.emall.common.core.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zengzhimin on 2017/8/29.
 */
@Data
public class StaticsSettleOrders implements Serializable{
    private static final long serialVersionUID = 4728366705424205803L;

    //统计日期
    private Date staticsDate;
   //订单总额
    private BigDecimal salesPrice;
   //配送费总额
    private BigDecimal deliveryPrice;
    //当日订单总数
    private Integer sumOrders;
    //明日预订总数
    private Integer nextDayOrders;
     //门店号
    private String storeNo;
    //门店名称
    private String storeName;
    //门店id
    private Integer storeId;
}
