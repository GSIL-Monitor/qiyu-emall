package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.vo.QiyuContentVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.dao.QiyuContentDao;
import com.qiyu.emall.dao.QiyuProductDao;
import com.qiyu.emall.entity.QiyuContent;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.service.QiyuContentService;
import com.qiyu.emall.service.QiyuProductService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QiyuContentServiceImpl implements QiyuContentService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuContentDao qiyuContentDao;
    /**
     * 根据文章id查询文章详情
     * @param id
     * @return
     */
    @Override
    public QiyuContentVo detail(Integer id) {
        logger.info("product detail id=",id);
        QiyuContent content = qiyuContentDao.detail(id);
        if(content==null){
            return null;
        }
        QiyuContentVo qiyuContentVo = new QiyuContentVo();
        buildContentVo(qiyuContentVo,content);
        return qiyuContentVo;
    }

    /**
     * 查询文章列表数据
     * @return
     */
    @Override
    public List<QiyuContentVo> list() {
        logger.info("content list param=");
        List<QiyuContent> contentList= qiyuContentDao.list();
        if(CollectionUtils.isEmpty(contentList)){
            return null;
        }
        List<QiyuContentVo> contentVos = new ArrayList<>();
        for(QiyuContent qiyuContent : contentList){
            QiyuContentVo contentVo = new QiyuContentVo();
            buildContentVo(contentVo,qiyuContent);
            contentVos.add(contentVo);
        }
        return contentVos;
    }

    private void buildContentVo(QiyuContentVo contentVo, QiyuContent content) {
        contentVo.setId(content.getId());
        contentVo.setName(content.getName());
        contentVo.setStatus(content.getStatus());
        contentVo.setPicture(content.getPicture());
        contentVo.setContent(content.getContent());
        contentVo.setCreateAt(content.getCreateAt());
        contentVo.setCreateBy(content.getCreateBy());
        contentVo.setUpdateAt(content.getUpdateAt());
        contentVo.setUpdateBy(content.getUpdateBy());
        content.setRemark(content.getRemark());
    }
}
