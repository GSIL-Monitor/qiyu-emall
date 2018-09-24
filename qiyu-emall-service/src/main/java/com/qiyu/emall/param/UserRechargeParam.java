package com.qiyu.emall.param;

import java.math.BigDecimal;

public class UserRechargeParam extends BaseParam {


    private String cardNo;

    private String cardPwd;

    //微信充值金额
    private BigDecimal amount;
    //微信交易号
    private BigDecimal wechatTradeNo;


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPwd() {
        return cardPwd;
    }

    public void setCardPwd(String cardPwd) {
        this.cardPwd = cardPwd;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getWechatTradeNo() {
        return wechatTradeNo;
    }

    public void setWechatTradeNo(BigDecimal wechatTradeNo) {
        this.wechatTradeNo = wechatTradeNo;
    }
}
