package com.qiyu.emall.common.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品vo
 */
@Data
public class StoreVo implements Serializable {
    private static final long serialVersionUID = 4728366705424205803L;
    private Integer storeId;
    private String storeNo;
    private String storeType;
    private String storeName;
    private String address;
    private String proviceName;
    private String cityName;
    private String description;
    private String contact;
    private String longitude;//经度
    private String latitude;//纬度
    private Integer sort;
    private String picture;//图片
    private BigDecimal postage;//配送费用
    private BigDecimal postageLimit;//配送减免金额
    private String openStartTime;//营业开始时间
    private String openEndTime;//营业结束时间
    private String deliveryTime;//配送时间
    private String serverAddress;//配送地址
    private Integer status;//0:关店,-1:禁用,1:开店
    private Integer merchantId;//店铺所属商户id
    private List<DeliveryTimeVo> deliveryTimeList;//配送时间List
}
