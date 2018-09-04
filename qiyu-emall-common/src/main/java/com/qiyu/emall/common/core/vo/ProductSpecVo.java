package com.qiyu.emall.common.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品规格vo
 */
@Data
public class ProductSpecVo implements Serializable {
    private static final long serialVersionUID = 388333059800851106L;
    private BigDecimal currentPrice;//原价
    private BigDecimal originalPrice;//现价
    private String specName;//规格名称
    private Integer specStock;//规格库存
    private String specId;//规格id
    private Integer id;//id
    private Integer productId;//商品id
}
