package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.utils.CollectionUtil;
import com.qiyu.emall.common.core.vo.QiyuBannerVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.dao.QiyuBannerDao;
import com.qiyu.emall.dao.QiyuProductDao;
import com.qiyu.emall.entity.QiyuBanner;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.service.QiyuBannerService;
import com.qiyu.emall.service.QiyuProductService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QiyuBannerServiceImpl implements QiyuBannerService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuBannerDao qiyuBannerDao;

    @Override
    public List<QiyuBannerVo> selectList() {
        List<QiyuBanner> qiyuBanners = qiyuBannerDao.selectList();
        if(CollectionUtils.isEmpty(qiyuBanners)){
            return null;
        }
        List<QiyuBannerVo> qiyuBannerVos = new ArrayList<>();
        for(QiyuBanner banner : qiyuBanners){
            QiyuBannerVo bannerVo = new QiyuBannerVo();
            buildVo(bannerVo,banner);
            qiyuBannerVos.add(bannerVo);
        }
        return qiyuBannerVos;
    }

    /**
     * 生成bannerVo
     * @param bannerVo
     * @param banner
     */
    private void buildVo(QiyuBannerVo bannerVo, QiyuBanner banner) {

    }
}
