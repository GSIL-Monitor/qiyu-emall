package com.qiyu.emall.exception;

import com.qiyu.emall.common.core.constants.BusinessExceptionEnum;

/**
 * Created by kejun on 2015/11/25.
 */
public class UserException extends RuntimeException{
    private static final long serialVersionUID = -3575171014317916257L;
    String code;

    public UserException()
    {
        super();
    }

    public UserException(String message)
    {
        super(message);
    }

    public UserException(String code, String message)
    {
        super(message);
        this.code = code;
    }

    public UserException(BusinessExceptionEnum exceptionEnum)
    {
        super(exceptionEnum.getValueStr());
        this.code = exceptionEnum.getCodeStr();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
