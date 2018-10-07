package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.QiyuProductVo;
import com.qiyu.emall.common.core.vo.QiyuShopCartVo;
import com.qiyu.emall.param.ProductSaveParam;
import com.qiyu.emall.param.ShopCartSearchParam;
import com.qiyu.emall.service.QiyuProductService;
import com.qiyu.emall.service.QiyuShopCartService;
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
import java.util.List;

@Controller
@RequestMapping("/shopCart")
public class QiyuShopCartController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QiyuShopCartService qiyuShopCartService;

    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseData detail(Integer id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询购物车详情={}",id);
        QiyuShopCartVo qiyuShopCartVo = null;
        try{
            qiyuShopCartVo = qiyuShopCartService.detail(id);
            if(qiyuShopCartVo==null){
                return ResponseData.failure(ConstantEnum.SHOPCART_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("shopCart detail exception",e);
            return ResponseData.failure(ConstantEnum.SHOPCART_SEARCH_ERROR);
        }
        return ResponseData.success(qiyuShopCartVo);
    }

    /**
     * 根据用户id查询购物车列表
     * @param userId
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(ShopCartSearchParam param, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("查询购物车列表");
        List<QiyuShopCartVo> shopCartVos = null;
        try{
            shopCartVos = qiyuShopCartService.list(param);
            if(shopCartVos==null){
                return ResponseData.failure(ConstantEnum.SHOPCART_SEARCH_ERROR);
            }
        }catch (Exception e){
            logger.error("shopcart list exception",e);
            return ResponseData.failure(ConstantEnum.SHOPCART_OPERATOR_ERROR);
        }
        return ResponseData.success(shopCartVos);
    }


    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData save(@RequestBody ProductSaveParam param, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("加入购物车数据param={}",param);
        try{
            qiyuShopCartService.save(param);
        }catch (Exception e){
            logger.error("shopcart save exception",e);
            return ResponseData.failure(ConstantEnum.SHOPCART_OPERATOR_ERROR);
        }
        return ResponseData.success();
    }
}
