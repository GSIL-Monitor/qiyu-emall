/**
 * @Copyright (C), 上海容易网电子商务有限公司
 * @Author: 柯军
 * @datetime:2015年5月19日下午3:45:21
 * @Description: TODO
 **/

package com.qiyu.emall.common.core.constants;

/**
 * @Author: 柯军
 * @Description: 异常错误常量枚举
 * @datetime:2015年5月19日下午3:45:21
 **/

public enum BusinessExceptionEnum {
    EXC_ERROR_SYSTEM("1000", "系统异常"),
    EXC_ERROR_PARAM_SYSTEM("1001", "缺少必要参数"),
    EXC_ERROR_SYSTEM_SIGN("1002", "签名错误"),

    //----------------网络数据相关异常-----------------------//
    EXCEPTION_REQUEST_ERROR("1020100", "网络请求异常"),
    EXCEPTION_RES_FAIL("1020101", "请求接口失败"),
    EXCEPTION_REQUEST_RESPONSE_PARSING_ERROR("1020102", "网络数据解析异常"),
    EXCEPTION_REQUEST_RESPONSE_EMPTY_ERROR("1020103", "网络数据返回为空"),

    //----------------用户权限相关异常-----------------------//
    EXCEPTION_USER_PARAMS_PAYMENT("1020401", "没有登录或登录信息错误"),//前台约定，没有登录统一后三位为401
    EXCEPTION_NO_AUTHORITY_PAYMENT("1020403", "没有访问该资源的权限"),//前台约定，没有权限统一后三位为403
    EXCEPTION_USER_IDENTITY("1020404", "没有获取登录用户身份信息"),
    EXCEPTION_USER_WE_CHAT("1020405", "微信开放Api获取注册用户信息异常"),
    EXCEPTION_USER_REGISTER("1020406", "注册用户信息异常"),
    EXCEPTION_OPERATOR_SMS_FAIL("1020408", "发送验证码失败"),
    EXCEPTION_OPERATOR_LOGIN_FAIL("1020409","登录失败"),
    EXCEPTION_OPERATOR_SMSCODE_ERROR("1020410","短信验证码输入有误"),
    EXCEPTION_OPERATOR_WEPHONE_ERROR("1020411","获取微信绑定手机号为空"),
    EXCEPTION_OPERATOR_PHONE_ERROR("1020412","登录手机号有误"),
    EXCEPTION_OPERATOR_LOGININFO_ERROR("1020413","无法获取操作员身份信息"),
    EXCEPTION_OPERATOR_SMSCODE_TIMEOUT("1020414","短信验证码已失效，请重新获取"),
    //----------------订单相关异常 10205开头-----------------------//
    EXCEPTION_ORDER_MONEY_MISS("1020501", "订单金额必须大于零"),
    EXCEPTION_ORDER_PRODUCT_MISS("1020502", "订单选购商品必须大于零"),
    EXCEPTION_ORDER_STOCK_MISS("1020503", "库存不够"),
    EXCEPTION_ORDER_PAY_MONEY_MISS("1020504", "订单传入金额有误,请重新下单"),
    EXCEPTION_ORDER_NOT_EXISTS("1020505", "订单不存在"),
    EXCEPTION_ORDER_HAS_PAYED("1020506", "订单已结支付,请勿重复发起支付"),
    EXCEPTION_ORDER_USER_MISS("1020507", "订单用户信息不存在"),
    EXCEPTION_ORDER_MEH_NO_MISS("1020508", "店铺已关闭"),
    EXCEPTION_ORDER_INVOKE_API("1020509", "调用开放api接口异常"),
    EXCEPTION_ORDER_SIGN_ERROR("1020510", "开发平台回调接口异常"),
    EXCEPTION_ORDER_NOTIFY_FAIL("1020511", "支付通知未成功"),
    EXCEPTION_ORDER_STOCK_ORDER_MISS("1020503", "库存不够,订单已撤销"),

    EXCEPTION_ORDER_NOTIFY_PAYED("1020512", "订单已处理，勿重复通知"),
    EXCEPTION_ORDER_NOTIFY_MONEY_MISS("1020513", "支付通知金额错误"),
    EXCEPTION_ORDER_PRINTER_COMMIT_MISS("1020514", "打印为提交"),
    EXCEPTION_ORDER_SPEC_FAIL("1020515", "商品规格不存在"),
    EXCEPTION_ORDER_PICKUP_FAIL("1020516", "订单自提信息不存在"),
    EXCEPTION_ORDER_STORE_MISS("1020517", "订单店铺相关信息不存在"),
    EXCEPTION_ORDER_PICKUP_MISS("1020518", "订单配送费传入有误!"),
    EXCEPTION_ORDER_NO_CLOSED_MISS("1020519", "非待支付的订单不能关闭"),
    EXCEPTION_ORDER_HAS_CLOSED_MISS("1020520", "此订单已经关闭，请勿重复发起操作"),
    EXCEPTION_ORDER_ADDRESS_MISS("1020521", "用户下单地址不存在"),
    EXCEPTION_ORDER_DEVERY_TIME_MISS("1020522", "此时间不在配送范围内，请重新选择配送时间"),
    EXCEPTION_ORDER_PICKUP_TIME_MISS("1020523", "此时间不在营业时间范围内，请重新选择自提时间"),
    EXCEPTION_ORDER_PRODUCT_STATUS("1020524", "商品已下架,不允许创建订单"),
    EXCEPTION_ORDER_NOPAYED_STATUS("1020525", "订单未支付"),
    //----------------商品、店铺、banner 相关异常 10206开头-----------------------//
    EXCEPTION_BANNER_LIST_ERROR("1020601", "查询banner列表异常"),
    EXCEPTION_BANNER_RELEASE("1020602", "同步banner数据异常"),
    EXCEPTION_AREA_RELEASE("1020603", "同步省市区数据异常"),
    EXCEPTION_PRODUCT_LIST("1020604", "商品列表查询异常"),
    EXCEPTION_PRODUCT_DETAIL("1020605", "商品详情查询异常"),
    EXCEPTION_PRODUCT_FORUSER("1020606", "猜你喜欢or推荐商品列表查询异常"),
    EXCEPTION_PRODUCTCATEGORY_LIST("1020606", "商品分类数据查询列表异常"),

    //----------------打印相关异常 10207开头-----------------------//
    EXCEPTION_PRINTER_DEVICE_STORE_EMPTY("1020701", "店铺ID不能为空"),
    EXCEPTION_PRINTER_DEVICE_EMPTY("1020702", "店铺没有打印设备"),
    EXCEPTION_PRINTER_INFO_INSERT_ERROR("1020703", "打印信息插入失败"),
    EXCEPTION_PRINTER_DEVICE_ERROR("1020704", "打印设备处于非正常使用状态"),
    //---------------------------------------//
    ;
    private Object code;

    private Object value;

    BusinessExceptionEnum(Object code, Object value) {
        this.code = code;
        this.value = value;
    }

    /**
     * @return
     * @Description: 获取code byte类型值,请确保该值可转换为byte值，否则会类型转换异常
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Byte getCodeByte() {
        return Integer.valueOf(code.toString()).byteValue();
    }


    /**
     * @return
     * @Description: 获取code int类型值,请确保该值可转换为int值，否则会类型转换异常
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Integer getCodeInt() {
        return Integer.valueOf(code.toString());
    }

    /**
     * @return
     * @Description: 获取code String类型值
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:53:36
     **/
    public String getCodeStr() {
        return code.toString();
    }

    /**
     * @return
     * @Description: 获取value byte类型值,请确保该值可转换为byte值，否则会类型转换异常
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Byte getValueByte() {
        return Integer.valueOf(value.toString()).byteValue();
    }

    /**
     * @return
     * @Description: 获取value int类型值,请确保该值可转换为int值，否则会类型转换异常
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Integer getValueInt() {
        return Integer.valueOf(value.toString());
    }

    /**
     * @return
     * @Description: 获取value String类型值
     * @Author: 柯军
     * @datetime:2015年5月19日下午3:53:21
     **/
    public String getValueStr() {
        return value.toString();
    }

    public Object getCode() {
        return code;
    }

    public Object getValue() {
        return value;
    }
}
