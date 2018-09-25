package com.qiyu.emall.param;

import java.math.BigDecimal;
import java.util.List;


public class MallOrderParam extends BaseParam {
    private static final long serialVersionUID = 4986532724864627157L;

    private Integer  orderId;

    //下单选购的商品
    private List<MallProductParam> productParams;
    //下单金额
    private BigDecimal payAmount;

}

