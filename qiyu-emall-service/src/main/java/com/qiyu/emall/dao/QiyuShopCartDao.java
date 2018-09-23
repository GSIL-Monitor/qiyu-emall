package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.entity.QiyuShopCart;
import com.qiyu.emall.mapper.QiyuProductMapper;
import com.qiyu.emall.mapper.QiyuShopCartMapper;
import com.qiyu.emall.param.ShopCartSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuShopCartDao {
    private QiyuShopCartMapper qiyuShopCartMapper;


    public QiyuShopCart detail(Integer id) {
        return qiyuShopCartMapper.selectByPrimaryKey(id);
    }

    public int insert(QiyuShopCart shopCart) {
        return qiyuShopCartMapper.insertSelective(shopCart);
    }

    public int delete(int shopCartId) {
        return qiyuShopCartMapper.deleteByPrimaryKey(shopCartId);
    }

    public List<QiyuShopCart> list(ShopCartSearchParam param) {
        return null;
    }
}
