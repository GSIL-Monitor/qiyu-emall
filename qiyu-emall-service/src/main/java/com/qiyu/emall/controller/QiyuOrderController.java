package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class QiyuOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public ResponseData createOrder(){

    }
}
