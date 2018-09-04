package com.qiyu.emall.common.core.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品vo
 */
@Data
public class ProductVo implements Serializable {
    private static final long serialVersionUID = -4913960945546789825L;
    private Integer productId;//商品id
    private List<String> pictureList;//商品图片
    private Integer categoryId;//分类id
    private String description;//商品描述
    private String productName;//商品名称
    private List<ProductSpecVo> specList;//商品规格列表
    private Integer status;//(0:下架,1:上架)
    private String characteristic;//商品特色
    private Integer storeId;//
    private Integer merchantId;//
    private String picture;//商品外展示图片
}
