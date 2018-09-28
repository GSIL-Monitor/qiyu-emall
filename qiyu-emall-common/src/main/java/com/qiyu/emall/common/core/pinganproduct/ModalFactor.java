package com.qiyu.emall.common.core.pinganproduct;

import java.math.BigDecimal;
import java.util.Date;

public class ModalFactor {

    // 险种代码
    private String planCode;
    // 月缴系数
    private BigDecimal mPremFactor;
    //季缴系数
    private BigDecimal qPremFactor;
    //半年系数
    private BigDecimal sPremFactor;
    //年缴系数
    private BigDecimal yPremFactor;
    //有效起期
    private Date startDate;
    //有效止期
    private Date endDate;
}
