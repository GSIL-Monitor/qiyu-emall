package com.qiyu.emall.entity;

import com.qiyu.emall.common.core.entity.BaseEntity;

import java.util.Objects;

public class QiyuProductSpec extends BaseEntity {
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 规格id
     */
    private Integer specId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public QiyuProductSpec(Integer id, Integer productId, Integer specId) {
        this.id = id;
        this.productId = productId;
        this.specId = specId;
    }

    public QiyuProductSpec() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QiyuProductSpec that = (QiyuProductSpec) o;
        return Objects.equals(specId, that.specId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specId);
    }
}