package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.vo.QiyuSpecificationVo;
import com.qiyu.emall.dao.QiyuSpecificationDao;
import com.qiyu.emall.entity.QiyuSpecification;
import com.qiyu.emall.param.SpecificationSearchParam;
import com.qiyu.emall.service.QiyuSpecificationService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QiyuSpecificationServiceImpl implements QiyuSpecificationService {

    @Autowired
    private QiyuSpecificationDao qiyuSpecificationDao;
    /**
     * 根据条件查询规格列表
     * @param specPram
     * @return
     */
    @Override
    public List<QiyuSpecificationVo> searchSpecList(SpecificationSearchParam specPram) {

        List<QiyuSpecification> specificationList = qiyuSpecificationDao.searchSpecList(specPram);
        if(CollectionUtils.isEmpty(specificationList)){
            return null;
        }
        List<QiyuSpecificationVo> specificationVos = new ArrayList<>();
        for(QiyuSpecification specification : specificationList){
            QiyuSpecificationVo specVo = new QiyuSpecificationVo();
            buildSpecVo(specVo,specification);
            specificationVos.add(specVo);
        }
        return specificationVos;
    }

    private void buildSpecVo(QiyuSpecificationVo specVo, QiyuSpecification specification) {
        specVo.setSpecId(specification.getId());
        specVo.setSpecName(specification.getSpecName());
        specVo.setParentId(specification.getParentId());
        specVo.setSpecLevel(specification.getSpecLevel());
        specVo.setSpecType(specification.getSpecType());
    }
}
