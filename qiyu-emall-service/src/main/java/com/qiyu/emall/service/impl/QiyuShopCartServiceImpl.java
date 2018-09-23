package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.vo.QiyuShopCartVo;
import com.qiyu.emall.dao.QiyuShopCartDao;
import com.qiyu.emall.entity.QiyuShopCart;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.param.ShopCartSearchParam;
import com.qiyu.emall.service.QiyuShopCartService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QiyuShopCartServiceImpl implements QiyuShopCartService {

    private QiyuShopCartDao qiyuShopCartDao;
    @Override
    public QiyuShopCartVo detail(Integer id) {
        QiyuShopCart shopCart =  qiyuShopCartDao.detail(id);
        if(shopCart!=null){
            QiyuShopCartVo shopCartVo = new QiyuShopCartVo();
            buildVo(shopCartVo,shopCart);
            return shopCartVo;
        }
        return null;
    }

    @Override
    public List<QiyuShopCartVo> list(ShopCartSearchParam param) {
        List<QiyuShopCart> shopCartList = qiyuShopCartDao.list(param);
        if(CollectionUtils.isNotEmpty(shopCartList)){
            List<QiyuShopCartVo> shopCartVoList = new ArrayList<>();
            for(QiyuShopCart shopCart :shopCartList){
                QiyuShopCartVo shopCartVo = new QiyuShopCartVo();
                buildVo(shopCartVo,shopCart);
                shopCartVoList.add(shopCartVo);
            }
            return shopCartVoList;
        }
        return null;

    }

    @Override
    public void save(ProductSaveParam param) {
        QiyuShopCart shopCart = new QiyuShopCart();
        buildShopCart(shopCart,param);
        qiyuShopCartDao.insert(shopCart);
    }

    @Override
    public int delete(int shopCartId) {
        return qiyuShopCartDao.delete(shopCartId);
    }


    private void buildShopCart(QiyuShopCart shopCart, ProductSaveParam param) {

    }

    private void buildVo(QiyuShopCartVo shopCartVo, QiyuShopCart shopCart) {
    }

}
