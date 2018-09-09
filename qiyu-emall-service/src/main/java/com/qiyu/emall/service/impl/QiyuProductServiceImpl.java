package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.dao.QiyuProductDao;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.service.QiyuProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QiyuProductServiceImpl implements QiyuProductService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuProductDao qiyuProductDao;
    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    @Override
    public QiyuProductVo detail(Integer id) {
        logger.info("product detail id=",id);
        QiyuProduct qiyuProduct = qiyuProductDao.detail(id);
        if(qiyuProduct==null){
            return null;
        }
        QiyuProductVo qiyuProductVo = new QiyuProductVo();
        buildProductVo(qiyuProductVo,qiyuProduct);
        return qiyuProductVo;
    }

    private void buildProductVo(QiyuProductVo qiyuProductVo, QiyuProduct qiyuProduct) {

    }
}
