package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.entity.QiyuProduct;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.service.QiyuProductService;
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
public class QiyuProductController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuProductService qiyuProductService;

    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseData detail(Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询商品详情id={}",id);
        QiyuProductVo qiyuProductVo = null;
        try{
            qiyuProductVo = qiyuProductService.detail(id);
            if(qiyuProductVo==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("product detail exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(qiyuProductVo);
    }

    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询商品列表");
        QiyuProductVo qiyuProductVo = null;
        try{
            List<QiyuProductVo> productVoList = qiyuProductService.list();
            if(qiyuProductVo==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("product detail exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(qiyuProductVo);
    }


    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData save(ProductSaveParam param,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("保存商品param={}",param);
        try{
            qiyuProductService.save(param);
        }catch (Exception e){
            logger.error("product save exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success();
    }

    @ResponseBody
    public ResponseData updateStatus(ProductSaveParam param,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("商品上下架param={}",param);
        try{
            qiyuProductService.updateStatus(param);
        }catch (Exception e){
            logger.error("product updateStatus exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success();
    }
}
