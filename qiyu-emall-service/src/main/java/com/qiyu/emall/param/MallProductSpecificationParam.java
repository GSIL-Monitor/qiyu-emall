package com.qiyu.emall.param;

public class MallProductSpecificationParam extends BaseParam{

    //规格分类id
    private Integer specificationId;
    //所选规格数量
    private Integer categoryNum;

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }
}
