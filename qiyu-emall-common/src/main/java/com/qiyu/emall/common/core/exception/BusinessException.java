package com.qiyu.emall.common.core.exception;


import com.qiyu.emall.common.core.constants.BusinessExceptionEnum;

public class BusinessException extends MallBaseException {
    private static final long serialVersionUID = 5117980659382038192L;

    public BusinessException(String code, String msgFormat, Object... args) {
        super(code, String.format(msgFormat, args));
    }

    public BusinessException(BusinessExceptionEnum constantEnum) {
        super(constantEnum.getValueStr());
        this.code = constantEnum.getCodeStr();
    }

    /**
     * 实例化异常
     *
     * @param msgFormat 消息格式化
     * @param args      参数
     * @return MallBaseException
     */
    public BusinessException newInstance(String msgFormat, Object... args) {
        return new BusinessException(this.code, msgFormat, args);
    }
}
