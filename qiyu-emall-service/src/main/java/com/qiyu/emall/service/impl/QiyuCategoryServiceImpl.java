package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.utils.CollectionUtil;
import com.qiyu.emall.common.core.vo.QiyuCategoryVo;
import com.qiyu.emall.entity.QiyuCategory;
import com.qiyu.emall.mapper.QiyuCategoryMapper;
import com.qiyu.emall.param.CategorySearchParam;
import com.qiyu.emall.service.QiyuCategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QiyuCategoryServiceImpl implements QiyuCategoryService {

    @Autowired
    private QiyuCategoryMapper qiyuCategoryMapper;
    @Override
    public List<QiyuCategoryVo> list(CategorySearchParam searchParam) {
        List<QiyuCategory> categoryList =  qiyuCategoryMapper.list(searchParam);
        if(CollectionUtils.isNotEmpty(categoryList)){
            List<QiyuCategoryVo> categoryVoList = new ArrayList<>();
            for(QiyuCategory category: categoryList){
                QiyuCategoryVo categoryVo = new QiyuCategoryVo();
            }
        }
        return null;
    }
}
