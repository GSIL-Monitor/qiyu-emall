package com.qiyu.emall.service;

import com.qiyu.emall.common.core.vo.QiyuBannerVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;

import java.util.List;

public interface QiyuBannerService {
    //查询有效的banner数据
    List<QiyuBannerVo> selectList();
}
