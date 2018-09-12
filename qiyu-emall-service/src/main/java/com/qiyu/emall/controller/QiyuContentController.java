package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuContentVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.mapper.QiyuContentMapper;
import com.qiyu.emall.service.QiyuContentService;
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
@RequestMapping("/content")
public class QiyuContentController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuContentService qiyuContentService;

    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseData detail(Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询文章详情id={}",id);
        QiyuContentVo qiyuContentVo = null;
        try{
            qiyuContentVo = qiyuContentService.detail(id);
            if(qiyuContentVo==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("content detail exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(qiyuContentVo);
    }

    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询文章列表");
        List<QiyuContentVo> qiyuContentVos = null;
        try{
            qiyuContentVos = qiyuContentService.list();
            if(qiyuContentVos==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("content list exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(qiyuContentVos);
    }
}
