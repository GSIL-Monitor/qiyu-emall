package com.qiyu.emall.param;

import com.qiyu.emall.common.core.param.BaseParam;

public class CategorySearchParam extends BaseParam {

    //上级分类id
    private String parentId;

    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
