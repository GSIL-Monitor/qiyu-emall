package com.qiyu.emall.common.core.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品分类vo
 */
@Data
public class ProductCategoryVo implements Serializable {
    private static final long serialVersionUID = -5135555566659359414L;
    private Integer categoryId;//分类id
    private String categoryName;//分类名称
    private String categoryNo;//分类no
    private String categoryType;//分类类型
    private Integer productCount;//分类下商品数量
    private Integer sort;//分类sort
}
