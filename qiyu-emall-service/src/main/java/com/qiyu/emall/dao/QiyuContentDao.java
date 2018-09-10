package com.qiyu.emall.dao;

import com.qiyu.emall.entity.QiyuContent;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.mapper.QiyuContentMapper;
import com.qiyu.emall.mapper.QiyuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QiyuContentDao {

    @Autowired
    private QiyuContentMapper qiyuContentMapper;
    /**
     * 查询文章详情
     * @param id
     * @return
     */
    public QiyuContent detail(Integer id) {
        return qiyuContentMapper.selectByPrimaryKey(id);
    }
    /**
     * 查询文章列表
     * @return
     */
    public List<QiyuContent> list() {
        return qiyuContentMapper.selectList();
    }
}
