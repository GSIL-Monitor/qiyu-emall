package com.qiyu.emall.service;

import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.param.UserRechargeParam;

public interface QiyuPayService {


    /**
     * 存储卡充值
     * @param rechargeParam
     * @return
     */
    ResponseData rechargeByCard(UserRechargeParam rechargeParam);
}
