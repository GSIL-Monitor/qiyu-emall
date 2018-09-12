package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuSpecificationVo;
import com.qiyu.emall.param.SpecificationSearchParam;

import java.util.List;

public interface QiyuSpecificationService {
    /**
     * 根据条件查询规格列表
     * @param specPram
     * @return
     */
    List<QiyuSpecificationVo> searchSpecList(SpecificationSearchParam specPram);
}
