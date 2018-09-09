package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuBannerVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.service.QiyuBannerService;
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
@RequestMapping("/banner")
public class QiyuBannerController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuBannerService qiyuBannerService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseData detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询banner列表=");
        List<QiyuBannerVo> bannerVoList = null;
        try{
            bannerVoList = qiyuBannerService.selectList();
            if(bannerVoList==null){
                return ResponseData.failure(ConstantEnum.PRODUCT_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("product detail exception",e);
            return ResponseData.failure(ConstantEnum.PRODUCT_OPERATOR_ERROR);
        }
        return ResponseData.success(bannerVoList);
    }
}
