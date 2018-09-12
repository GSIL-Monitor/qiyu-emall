package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.mapper.QiyuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuProductDao {

    @Autowired
    private QiyuProductMapper qiyuProductMapper;

    /**
     * 查询文章详情
     * @param id
     * @return
     */
    public QiyuProduct detail(Integer id) {
        return qiyuProductMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询文章列表
     * @return
     */
    public List<QiyuProduct> list() {
        return qiyuProductMapper.selectList();
    }

    public int update(QiyuProduct qiyuProduct) {
        return qiyuProductMapper.updateByPrimaryKeySelective(qiyuProduct);
    }

    public int insert(QiyuProduct qiyuProduct) {
        return qiyuProductMapper.insertSelective(qiyuProduct);
    }
}
