package com.qiyu.emall.common.core.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zengzhimin on 2017/7/24.
 */
@Data
public class MallOrderVo implements Serializable {
    private static final long serialVersionUID = 1124845748929540197L;

    /**
     * d订单id
     */
    private Integer orderId;
    //下单时间
    private Date createOrderTime;
    /**
     * 店铺id
     */
    private Integer storeId;

    //店铺名称
    private String storeName;

    //订单状态(0:待支付,1:已支付,2:已拒单,3:待配送,4:已关闭,5:待自提,6:已完成,7:已退款)
    private Integer status;

    //订单价格
    private BigDecimal orderAmonut;

    /**
     * 订单商品信息
     */
    private List<MallOrderProductVo> orderProductVoList;

    /**
     * 用户下单地址
     */
    private UserAddressVo userAddressVo;

    /**
     * 配送方式(0:自提,1:店家配送,2:物流配送)
     */
    private Integer deliveryWay;

    /**
     * 下单备注
     */
    private String remark;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 提货码
     */
    private String pickUpCode;

    private Date deliveryAt;//配送时间
    private BigDecimal deliveryMoney;//运费
}
