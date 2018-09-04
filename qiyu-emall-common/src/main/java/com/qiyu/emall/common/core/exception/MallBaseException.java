package com.qiyu.emall.common.core.exception;

import java.io.Serializable;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/1 下午9:01
 * Description: 业务异常基础类，其它相关的业务异常必须继承此类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/1      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class MallBaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 570211819250143242L;
    /**
     * 异常信息
     */
    protected String msg;
    /**
     * 异常码
     */
    protected String code;

    public MallBaseException(String code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public MallBaseException() {
        super();
    }

    public MallBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public MallBaseException(Throwable cause) {
        super(cause);
    }

    public MallBaseException(String message) {
        super(message);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat 消息格式化
     * @param args      参数
     * @return MallBaseException
     */
    public MallBaseException newInstance(String msgFormat, Object... args) {
        return new MallBaseException(this.code, msgFormat, args);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
