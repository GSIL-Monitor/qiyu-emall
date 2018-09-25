package com.qiyu.emall.param;

import java.util.List;

public class MallProductParam extends BaseParam {
   private static final long serialVersionUID = -7774919431220565584L;
   //商品id
   private Integer productId;
   //规格分类
   private List<MallProductSpecificationParam> specificationDtos;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<MallProductSpecificationParam> getSpecificationDtos() {
        return specificationDtos;
    }

    public void setSpecificationDtos(List<MallProductSpecificationParam> specificationDtos) {
        this.specificationDtos = specificationDtos;
    }
}
