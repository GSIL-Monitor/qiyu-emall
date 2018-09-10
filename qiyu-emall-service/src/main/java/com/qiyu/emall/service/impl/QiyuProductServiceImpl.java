package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.dao.QiyuProductDao;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.service.QiyuProductService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 查询商品列表数据
     * @return
     */
    @Override
    public List<QiyuProductVo> list() {
        logger.info("product list param=");
        List<QiyuProduct> products = qiyuProductDao.list();
        if(CollectionUtils.isEmpty(products)){
            return null;
        }
        List<QiyuProductVo> productVos = new ArrayList<>();
        for(QiyuProduct product : products){
            QiyuProductVo productVo = new QiyuProductVo();
            buildProductVo(productVo,product);
            productVos.add(productVo);
        }
        return productVos;
    }

    private void buildProductVo(QiyuProductVo qiyuProductVo, QiyuProduct qiyuProduct) {
        qiyuProductVo.setId(qiyuProduct.getId());
        qiyuProductVo.setProductName(qiyuProduct.getProductName());
        qiyuProductVo.setProductBar(qiyuProduct.getProductBar());
        qiyuProductVo.setIsRecommend(qiyuProduct.getIsRecommend());
        qiyuProductVo.setStatus(qiyuProduct.getStatus());
        qiyuProductVo.setCategoryId(qiyuProduct.getCategoryId());
        qiyuProductVo.setSort(qiyuProduct.getSort());
        qiyuProductVo.setDescription(qiyuProduct.getDescription());
        qiyuProductVo.setPicture(qiyuProduct.getPicture());
        qiyuProductVo.setStock(qiyuProduct.getStock());
        qiyuProductVo.setPvNum(qiyuProduct.getPvNum());
        qiyuProductVo.setFavNum(qiyuProduct.getFavNum());
        qiyuProductVo.setCommentNum(qiyuProduct.getCommentNum());
        qiyuProductVo.setOriginalPrice(qiyuProduct.getOriginalPrice());
        qiyuProductVo.setCurrentPrice(qiyuProduct.getCurrentPrice());
        qiyuProductVo.setPictureUrlList(qiyuProduct.getPritureUrlList());
        qiyuProductVo.setCreateAt(qiyuProduct.getCreateAt());
        qiyuProductVo.setCreateBy(qiyuProduct.getCreateBy());
        qiyuProductVo.setUpdateAt(qiyuProduct.getUpdateAt());
        qiyuProductVo.setUpdateBy(qiyuProduct.getUpdateBy());
    }
}
