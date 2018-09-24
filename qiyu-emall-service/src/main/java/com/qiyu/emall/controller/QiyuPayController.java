package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.exception.BusinessException;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.param.UserRechargeParam;
import com.qiyu.emall.service.QiyuPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class QiyuPayController extends BaseController {

    private Logger log = LoggerFactory.getLogger(QiyuUserController.class);


    @Autowired
    private QiyuPayService qiyuPayService;

    @RequestMapping(value = "/card/recharge" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseData rechargeByCard(@RequestBody UserRechargeParam rechargeParam) {

        log.info("用户存储卡充值 rechargeParam={}",rechargeParam);
        try {
            return qiyuPayService.rechargeByCard(rechargeParam);
        } catch(BusinessException e){
            log.error("用户存储卡充值业务异常: code={},errMsg={}",e.getCode(),e.getMsg());
            return ResponseData.failure(e);
        }catch (Exception e) {
            log.error("用户存储卡充值异常",e);
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }

    }

}
