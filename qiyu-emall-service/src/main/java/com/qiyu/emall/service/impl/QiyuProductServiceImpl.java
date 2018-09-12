package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.constants.Constant;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.dao.*;
import com.qiyu.emall.entity.*;
import com.qiyu.emall.mapper.QiyuProductSpecStockMapper;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.param.SpecificationParam;
import com.qiyu.emall.service.QiyuProductService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class QiyuProductServiceImpl implements QiyuProductService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuProductDao qiyuProductDao;
    @Autowired
    private QiyuProductPictureDao qiyuProductPictureDao;
    @Autowired
    private QiyuProductCategoryDao qiyuProductCategoryDao;
    @Autowired
    private QiyuProductSpecDao qiyuProductSpecDao;
    @Autowired
    private QiyuProductSpecStockDao qiyuProductSpecStockDao;
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

    /**
     * 保存商品信息
     * @param param
     */
    @Override
    public void save(ProductSaveParam param) {
        QiyuProduct qiyuProduct = new QiyuProduct();
        buildProduct(qiyuProduct,param);
        //修改商品
        if(param.getProductId()!=null){
            qiyuProduct.setUpdateAt(new Date());
            qiyuProductDao.update(qiyuProduct);
        }else{
            qiyuProduct.setCreateAt(new Date());
            qiyuProductDao.insert(qiyuProduct);
        }
        List<QiyuProductPicture> pictureList = new ArrayList<>();
        buildPictureList(pictureList,param,qiyuProduct);
        //先删除已有的商品图片关联关系
        qiyuProductPictureDao.deleteByProductId(qiyuProduct.getId());
        if(pictureList!=null && pictureList.size()>0){
            qiyuProductPictureDao.batchInsert(pictureList);
        }
        //新增商品分类关系
        saveProductCategory(qiyuProduct);
        //新增商品规格关系，商品规格库存数据
        saveProductSpec(param,qiyuProduct);

    }

    @Override
    public void updateStatus(ProductSaveParam param) {
        QiyuProduct product = new QiyuProduct();
        product.setId(param.getProductId());
        product.setStatus(param.getStatus());
        qiyuProductDao.update(product);
    }

    private void saveProductCategory(QiyuProduct qiyuProduct) {
        QiyuProductCategory productCategory = new QiyuProductCategory();
        productCategory.setProductId(qiyuProduct.getId());
        productCategory.setCategoryId(qiyuProduct.getCategoryId());
        productCategory.setCreateAt(new Date());
        qiyuProductCategoryDao.deleteByProductId(productCategory.getProductId());
        qiyuProductCategoryDao.insert(productCategory);
    }

    private void saveProductSpec(ProductSaveParam param,QiyuProduct qiyuProduct) {
        if(CollectionUtils.isNotEmpty(param.getSpecParamList())){
            Set<QiyuProductSpec> productSpecSet = new HashSet<>();
            List<QiyuProductSpecStock> specStockList = new ArrayList<>();
            for(SpecificationParam specParam : param.getSpecParamList()){
                QiyuProductSpec productSpec = new QiyuProductSpec();
                QiyuProductSpecStock specStock = new QiyuProductSpecStock();
                if(CollectionUtils.isNotEmpty(specParam.getSpecIds())){
                    StringBuffer specCode = new StringBuffer(",");
                    for(String specId : specParam.getSpecIds()){
                        productSpec.setProductId(qiyuProduct.getId());
                        productSpec.setSpecId(Integer.parseInt(specId));
                        specCode.append(specId+",");
                        productSpecSet.add(productSpec);
                    }
                    specStock.setSpecCode(specCode.toString());
                    specStock.setProductId(qiyuProduct.getId());
                    specStock.setStock(specParam.getStock());
                    specStock.setCurrentPrice(new BigDecimal(specParam.getCurrentPrice()));
                    specStock.setOriginalPrice(new BigDecimal(specParam.getOriginalPrice()));
                    specStockList.add(specStock);
                }
            }
            //新增商品规格关联关系
            qiyuProductSpecDao.deleteByProductId(qiyuProduct.getId());
            qiyuProductSpecDao.batchInsert(productSpecSet);
            //新增商品规格库存表
            qiyuProductSpecStockDao.deleteByProductId(qiyuProduct.getId());
            qiyuProductSpecStockDao.batchInsert(specStockList);
        }
    }

    private void buildPictureList(List<QiyuProductPicture> pictureList, ProductSaveParam param, QiyuProduct qiyuProduct) {
        if(CollectionUtils.isNotEmpty(param.getPictureList())){
            for(String pic:param.getPictureList()){
                QiyuProductPicture picture = new QiyuProductPicture();
                picture.setProductId(qiyuProduct.getId());
                picture.setPicture(pic);
                pictureList.add(picture);
            }
        }
    }

    private void buildProduct(QiyuProduct qiyuProduct, ProductSaveParam param) {
        qiyuProduct.setId(param.getProductId());
        qiyuProduct.setProductName(param.getProductName());
        qiyuProduct.setProductBar(param.getProductBar());
        qiyuProduct.setIsRecommend(param.getIsRecommend());
        qiyuProduct.setStatus(Constant.PRODUCT_STATUS_VALID);
        qiyuProduct.setCategoryId(param.getCategoryId());
        qiyuProduct.setCurrentPrice(new BigDecimal(param.getCurrentPrice()));
        qiyuProduct.setOriginalPrice(new BigDecimal(param.getOriginalPrice()));
        qiyuProduct.setPicture(param.getPicture());
        qiyuProduct.setDescription(param.getDescription());
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
