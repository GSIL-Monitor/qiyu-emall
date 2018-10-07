package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuCategoryVo;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.param.CategorySearchParam;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.service.QiyuCategoryService;
import com.qiyu.emall.service.QiyuProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class QiyuCategoryController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuCategoryService qiyuCategoryService;


    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(@RequestBody  CategorySearchParam searchParam, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询商品分类列表");
        List<QiyuCategoryVo> qiyuCategoryVos = new ArrayList<>();
        try{
            qiyuCategoryVos = qiyuCategoryService.list(searchParam);
            if(qiyuCategoryVos==null){
                return ResponseData.failure(ConstantEnum.CATEGORY_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("category list exception",e);
            return ResponseData.failure(ConstantEnum.CATEGORY_OPERATOR_ERROR);
        }
        return ResponseData.success(qiyuCategoryVos);
    }
}
