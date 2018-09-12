package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.common.core.vo.QiyuSpecificationVo;
import com.qiyu.emall.param.SpecificationSearchParam;
import com.qiyu.emall.service.QiyuProductService;
import com.qiyu.emall.service.QiyuSpecificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class QiyuSpecificationController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuSpecificationService qiyuSpecificationService;

    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(SpecificationSearchParam specPram,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询规格列表数据param=",specPram);
        List<QiyuSpecificationVo> specVoList = null;
        try{
            specVoList = qiyuSpecificationService.searchSpecList(specPram);
            if(specVoList==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("specification list exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(specVoList);
    }
}
