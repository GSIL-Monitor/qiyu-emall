package com.qiyu.emall.common.core.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zengzhimin on 2017/7/24.
 */
@Data
public class MallOrderProductVo implements Serializable {
    private static final long serialVersionUID = -6653721662990995973L;

    /**
     * 规格id
     */
    private Integer specId;
    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品条码
     */
    private String productBar;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品数
     */
    private int productCount;

    /**
     * 商品总价
     */
    private BigDecimal productPrice;

    /**
     * 商品单价
     */
    private BigDecimal perProductPrice;
}
