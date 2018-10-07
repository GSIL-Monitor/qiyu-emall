package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuCategoryVo;
import com.qiyu.emall.param.CategorySearchParam;

import java.util.List;

public interface QiyuCategoryService {
    /**
     * 查询商品分类列表
     * @return
     * @param searchParam
     */
    List<QiyuCategoryVo> list(CategorySearchParam searchParam);

}
