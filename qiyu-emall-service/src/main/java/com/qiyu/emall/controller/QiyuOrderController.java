package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.param.MallOrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class QiyuOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public ResponseData createOrder(@RequestBody MallOrderParam orderParam){
        return null;

    }
}
