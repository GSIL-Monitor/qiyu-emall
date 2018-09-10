package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuContentVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;

import java.util.List;

public interface QiyuContentService {
    /**
     * 根据文章id查询文章详情
     * @param id
     * @return
     */
    QiyuContentVo detail(Integer id);

    /**
     * 查询文章列表
     * @return
     */
    List<QiyuContentVo> list();
}
