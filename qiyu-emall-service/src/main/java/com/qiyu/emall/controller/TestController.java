package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/test")
    @ResponseBody
    public ResponseData upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("test");
        return ResponseData.success();
    }
}
