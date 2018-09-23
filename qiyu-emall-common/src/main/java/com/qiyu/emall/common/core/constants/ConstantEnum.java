/**
 * @Copyright (C),上海容易网电子商务有限公司	
 * @Author: 柯军 
 * @datetime:2015年5月19日下午3:45:21
 * @Description: TODO
 *
 **/

package com.qiyu.emall.common.core.constants;

/**
 * @Author: 柯军
 * @Description: 常量枚举
 * @datetime:2015年5月19日下午3:45:21
 * 
 **/

public enum ConstantEnum {
    EXC_ERROR_SYSTEM("1000", "系统异常"),
	FIAL_USER_PARAMS_PAYMENT(1018401, "没有登录或登录信息错误"),//前台约定，没有登录统一后三位为401
	FIAL_NO_AUTHORITY_PAYMENT(1018403, "没有访问该资源的权限"),//前台约定，没有权限统一后三位为403
	FIAL_USER_IDENTITY(1018404, "没有获取登录用户身份信息"),

    IS_DELETE_0(0,"正常"),
    IS_DELETE_1(1,"删除"),
    PAY_STATUS_O(0,"未付款"),
    PAY_STATUS_1(1,"已付款"),
    SEND_STATUS_O(0,"未发送"),
    SEND_STATUS_1(1,"已发送"),
    RECON_FLAG_1(1,"对账一致"),
    RECON_FLAG_2(2,"对账异常"),

    PAYMENT_TYPE_0(0,"银行卡"),
    PAYMENT_TYPE_1(1,"微信"),
    PAYMENT_TYPE_2(2,"支付宝"),
    PAYMENT_TYPE_3(3,"现金"),

    EXC_EXIST_CONFIG("111001", "配置已存在"),
    EXC_PARAM_NOT_EXIST_SHOPID("111002", "无效的店铺"),
    EXC_PARAM_NOT_EXIST_CONFIG_TYPE("111003", "无效的配置类型"),
    EXC_PARAM_NOT_EXIST("111004", "请填写完整信息"),
    EXC_PARAM_NOT_EXIST_ID("111005", "请选择需要操作的记录"),
    EXC_RECODE_NOT_FOUND("111006","记录不存在"),
    EXC_CLONE("111007", "复制属性异常"),
    EXC_INVALID_SHOP_CONFIG("111008", "商户配置无效"),
    EXC_PARAM_EXCHANGE("111009", "入参转换异常"),
    EXC_EMAIL_SENDED("111010", "对账单邮件已发送,无需再次发送"),
    EXC_OBJECT_EXCHANGE("111011", "对象转换异常"),
    EXC_INVALID_GROUP_CONFIG("111012", "集团配置无效"),
    EXC_NOT_EXIST_CONFIG_NEED_ADD("111013", "店铺配置不存在，请先新增"),
    EXC_PARAM_NOT_EXIST_SHOPMID("111014", "店铺ID为空"),
    EXC_EXIST_SERIALNO("111015", "终端号已存在"),
    EXC_NOT_EXIST_SHOP_POS("111016", "终端没有注册"),
    EXC_NOT_MATCH_MOBILE("111017", "手机号不匹配"),
    EXC_DELETE_POS_CACHE("111018", "删除pos缓存异常"),
    EXC_NOT_EXIST_PHONE("111019", "手机号不存在"),
    EXC_GROUPCONFIG_EXIST("111020", "积分供应商{}在有效期@已存在配置，请重新配置"),
    EXC_GROUPCONFIG_DATE("111021", "配置生效日期不正确"),
    EXC_GROUPCONFIG_STOP("111022", "该积分供应商下还存在供应商合同协议配置，请先终止供应商合同协议后在停用该积分供应商"),
    EXC_GROUPCONFIG_CONTRACTNO("111023", "合同号有重复，请修改合同号"),

	ERROR_DATA_CONFIG("111114", "配置数据异常"),
	ERROR_SETTLE_CYCLE("111115", "周期必须在1-90天内"),
	ERROR_SHOP_CONFIG_EXPIRED("111116", "商户配置过期"),
	ERROR_PARAM("111117", "入参错误"),
	ERROR_AREA_TYPE_ALL_UPDATE("111118", "周期只允许统一修改"),
	ERROR_CONTRACT_START_TIME("111119", "有效期开始时间不能早于明天"),
	ERROR_CONTRACT_END_TIME("111120", "有效期结束时间不能早于开始时间"),
	ERROR_GROUP_CONFIG_EXPIRED("111121", "集团配置过期"),
	ERROR_NOT_EXIST_SHOP_CONFIG("111122", "非联营配置不存在"),
	ERROR_EXIST_SERIAL_NO("111123", "终端号已存在"),
	ERROR_NOT_UPDATE("111124", "配置没有改动"),
	ERROR_FTP_DOWNLOAD_FAIL("111125", "FTP下载拉卡拉对账单失败"),
	ERROR_PATTER_SERIAL_NO("111126", "终端号格式为1~30位字母或数字"),
	ERROR_MALL_CONFIG_NOT_EXIST("111127", "该联营配置不存在"),
	ERROR_CONTRACT_EXPIRED("111128", "合同已过期"),
	ERROR_GROUP_SCOPE_NOT_EXIST("111129", "不允许使用该积分商提供的积分"),
	ERROR_NOT_EXIST_MALL_CONFIG("111130", "联营配置不存在"),
	ERROR_CONTRACT_END_DATE("111131", "有效期结束时间不能早于今天"),
	ERROR_DEDUCTION_POINT("111132", "扣点必须在0-100"),
	
	ERROR_NOT_EXIST_SHOP("111200", "店铺不存在"),
	ERROR_EXIST_VALID_CONFIG("111201", "{0}在有效期{1}-{2}已存在配置，请重新配置"),
	ERROR_NOT_EXIST_PAYMENT_BILL_CONFIG("111202", "商户配置不存在"),
	ERROR_EXIST_CONTRACT_NO("111203", "合同号有重复，请修改合同号"),
	ERROR_BEYOND_POS_SIZE("111204", "一次性最多保存20条pos配置"),
	ERROR_REPEAT_SERAIL_NO("111205", "POS终端号不允许重复"),
	ERROR_INVALID_CONFIG("111206", "不是有效的配置"),
	ERROR_EXIST_ENBALE_POS("111207", "已存在启用的POS"),
	ERROR_NO_ENABLE_POS("111208", "没有启用的POS"),
	ERROR_REPEAT_SHOP("111209", "绑定了重复的店铺"),
	ERROR_MODIFY_CONFIG_STATUS("111210", "配置状态不允许修改"),
	ERROR_EXIST_VALID_SHOP_CONFIG("111211", "店铺{0}在有效期{1}-{2}已存在配置，请重新配置"),
	ERROR_NEED_PAYMENT_BILL_CONFIG("111212", "该商户还未配置商户协议，无法配置pos"),
	ERROR_MANAGE_PWD("111214", "主管密码错误"),
    ERROR_MCH_POINT_LOW("111215","通道商户扣率不能少于0.2"),
    ERROR_CHANNEL_EXISTS("111216","通道已经存在"),
    ERROR_MCH_INFO_NOEXIST("111217", "商户不存在,无法新建"),
    ERROR_CHANNEL_ENSTATUES("111218","交易通道是启用的,请先停用此通道再修改"),

	ERROR_MCH_INFO_EXIST("111300", "该入驻商户已存在,无法新建"),
	ERROR_ENABLE_MCH_INFO_EXIST("111301","该入驻商户已存在，无法启用"),
	ERROR_STOP_MCH_INFO("111302","该入驻商户下还存在商户合同协议配置，请先终止商户合同协议后在停用该入驻商户"),
	ERROR_NO_ENABLE_MCH_INFO("111303","没有启用的入驻商户"),
	ERROR_MCH_INFO_WECHAT_PAY_CRET_NULL("111304","证书路径为空，请重新上传"),
	ERROR_MCH_INFO_WECHAT_PAY_CRET_SIZE("111305","证书文件大小超过了最大限制"),
	ERROR_MCH_INFO_WECHAT_PAY_CRET_TYPE("111306","证书文件类型错误"),
	ERROR_MCH_INFO_WECHAT_PAY_CRET_NAME("111308","证书名称与商户号不匹配"),
	ERROR_ADD_MCH_INFO("111307", "新建入驻商户出错"),
	ERROR_DATA_MCH_INFO("111308", "商户配置异常"),
	ERROR_AUTH_ERROR_APPID("111309", "请用商户支付宝账号授权"),
	ERROR_NOT_ALI_AUTH("111310", "支付宝账号未授权"),
	ERROR_PAY_TYPE_NOT_RONGYI("111311","支付方式不是容易网"),
	ERROR_GET_ALI_AUTH_URL("111312","获取支付宝授权失败"),
	ERROR_UPLOAD_QRCODE("111313","上传二维码失败"),
    ERROR_CHANNEL_NOT_EXISTS("111314","交易通道不存在"),
    ERROR_CHANNEL_MCH_UNVALID("111315","交易通道下的商户无效"),
    ERROR_CHANNEL_EXISTS_USED("111315","该通道已经被其他商户使用，不能停用"),
	ERROR_UPLOAD("117000", "上传文件失败"),
	ERROR_GEN_QRCODE("117001", "生成二维码失败"),
    ERROR_DOWNLOAD("117002", "下载文件失败"),

	ERROR_NOT_EXIST_SETTLE("1110400", "结算信息不存在"),
	ERROR_INTERFACE_USER("1110401", "结算信息查询用户接口异常"),
	ERROR_POS_SETTLE("1110402", "pos绑定结算对象错误"),


	ERROR_THIRDSTATEMENT_STATUS("1110500", "审核状态错误"),
	ERROR_THIRDSTATEMENT_REASON("1110501", "请填写审核不通过理由"),

    ERROR_FILENAME("1110502", "上传文件名校验不通过"),
    ERROR_THIRDSTATEMENT_UPLOAD_STATUS("1110503", "重复上传文件状态错误"),
    ERROR_FILE_CONTENT("1110504", "上传文件内容校验错误"),
    ERROR_FUTURE_FILE("1110505", "上传文件日期有误"),

    ERROR_ALREADY_UPDATE_MCH_STATEMENT("1110600", "对账单已生成，请勿重复生成"),
    ERROR_NONE_PASS_STATEMENT_DETAIL("1110601", "没有审核通过的对账单"),
    ERROR_NONE_UPLOAD_STATEMENT_DETAIL("1110602", "没有上传对账单"),
    ERROR_HAS_FAIL_STATEMENT("1110603", "对账单需要全部审核通过"),

    ERROR_MCH_PAY_INFO_INVALID("1110703", "所选的交易通道已停用，请选择别的可用通道"),
    ERROR_STATEMENT_ERROR_INVALID("1110704", "差错帐处理记录不存在"),

    ERROR_APPLYREFUND_EXISTS("1120001", "该订单已申请退款，请耐心等待"),
    ERROR_APPLYREFUND_YES("1120002", "该订单已退款成功"),

    ERROR_APPLYREFUND_AMOUNT_EXISTS("1120003", "该订单已申请退款，请耐心等待"),
    ERROR_APPLYREFUND_AMOUNT_OVER("1120004", "申请退款的金额超过可退款金额，请调整后重新提交"),


    ERROR_APPLYREFUND_NOEXISTS("1120003", "支付订单不存在"),

    ERROR_CHANNEL_NO("1120003", "查询渠道商户号失败"),

    PAYMENT_BILL_TYPE_MERCHANT(0,"商户"),
    PAYMENT_BILL_TYPE_GROUP(1,"积分商"),
    STATUS_ENABLE(0,"启用"),
    STATUS_DISABLE(1,"停用"),
    
	AREA_TYPE_ALL(0, "全部"),
	AREA_TYPE_SHOP(1, "店铺"),
	AREA_TYPE_MALL(2, "商场"),
	AREA_TYPE_GROUP(3, "集团"),
	
	DEFAULT_SETTLE_CYCLE(7, "默认周期"),

    SCOPE_TYPE_MALL(0,"商场"),//范围类型
    SCOPE_TYPE_SHOP(1,"店铺"),

	AREA_TYPE_PROVINCE(0, ""),// 省
	AREA_TYPE_CITY(1, "City"),// 市
	AREA_TYPE_DISTRIBUTE(2, "District"),// 区
	AREA_TYPE_BUSINESSDISTRICT(3, "BusinessDistrict"),// 商圈
	
    PAGE_SIZE(10,"分页条数"),
    
    MAX_PAGE_SIZE(1000,"分页条数"),
    
    POS_TYPE_SHOP(0, "店铺"),
    POS_TYPE_MALL(1, "商场"),
    
    POS_RESIDE_TYPE_RONGYI(0,"容易网"),
    POS_RESIDE_TYPE_MERCHANT(1,"商户"),

    GROUPCONFIG_STATUS_DISABLE(0,"未生效"),
    GROUPCONFIG_STATUS_ENABLE(1,"生效"),
    GROUPCONFIG_STATUS_TERMINATE(2,"终止"),
    GROUPCONFIG_STATUS_END(3,"结束"),
    GROUPCONFIG_STATUS_INVALID(4,"失效"),

    PAYMENT_BILL_CONFIG_STATUS_DISABLE(0,"未生效"),
    PAYMENT_BILL_CONFIG_STATUS_ENABLE(1,"生效"),
    PAYMENT_BILL_CONFIG_STATUS_TERMINATE(2,"终止"),
    PAYMENT_BILL_CONFIG_STATUS_END(3,"结束"),
    PAYMENT_BILL_CONFIG_STATUS_INVALID(4,"失效"),
    
    PAYMENT_BILL_CONFIG_IS_OVERALL_YES(0, "是"),
    PAYMENT_BILL_CONFIG_IS_OVERALL_NO(1, "否"),
    
    PAYMENT_BILL_CONFIG_TYPE_SHOP(0,"店铺"),
	PAYMENT_BILL_CONFIG_TYPE_MALL(1,"商场"),
    PAYMENT_BILL_CONFIG_TYPE_BRAND(2,"品牌"),

    MCH_AUTH_STATUS_NO(0,"未授权"),
    MCH_AUTH_STATUS_YES(1,"已授权"),


    THIRDSTATEMENT_STATUS_PASS(1,"审核通过"),
    THIRDSTATEMENT_STATUS_NOTPASS(-1,"审核不通过"),
    THIRDSTATEMENT_STATUS_CHECKING(2,"审核中"),
    THIRDSTATEMENT_STATUS_GENING(3,"生成中"),
    THIRDSTATEMENT_STATUS_GENERATED(4,"生成完成"),

    OPLOG_MODEL_WEBANK(0,"微众对账单"),
    OPLOG_MODEL_WEBANK_GEN(1,"微众对账单-生成"),

    THIRDSTATEMENT_TRADETYPE_PAY("01","消费"),
    THIRDSTATEMENT_TRADETYPE_REFUND("02","退货"),
    THIRDSTATEMENT_TRADETYPE_REVOKE("03","冲正/撤销"),

    THIRDSTATEMENT_TRADETYPE_ALIORIGINAL_PAY("01","交易"),
    THIRDSTATEMENT_TRADETYPE_ALIORIGINAL_REFUND("02","退款"),
    THIRDSTATEMENT_TRADETYPE_ALIORIGINAL_REVOKE("03","冲正/撤销"),
    THIRDSTATEMENT_TRADETYPE_ALIORIGINAL_OTHER("04","其他"),

    THIRDSTATEMENT_BILLSOURCE_WECHAT(0,"微信"),
    THIRDSTATEMENT_BILLSOURCE_ALIPAY(1,"支付宝"),
    THIRDSTATEMENT_BILLSOURCE_ALIORIGINAL(2,"支付宝原生"),


    THIRDSTATEMENT_PAYTYPE_ALIPAY(0,"支付宝"),
    THIRDSTATEMENT_PAYTYPE_WECHAT(1,"微信"),

    STATEMENT_SYSCHECK_ERROR(1,"系统审核失败，订单号：{}记录有误"),
    STATEMENT_SYSCHECK_ERROR_NOORDER(1,"系统审核失败"),

    MANAGE_PWD_SALT("566556dae4b027b99f30a057","主管密码加密盐值"),

    CURRENT_PAGE(1,"默认页数"),

    AlICHANNEL(2,"支付宝通道"),
    WECHATCHANNEL(1,"微信通道"),

    REFUND_APPLY_STATUS_0(0,"待审核"),
    REFUND_APPLY_STATUS_1(1,"审核通过待退款"),
    REFUND_APPLY_STATUS_2(2,"审核通过退款成功"),
    REFUND_APPLY_STATUS_3(3,"审核通过退款失败"),
    REFUND_APPLY_STATUS_4(4,"审核不通过"),


    RECON_REDIS_PARAM_ERROR("1130001", "无效的参数"),
    RECON_REDIS_EXCEPTION("1130002", "操作redis异常"),

    IMAGE_UPLOAD_EMPTY_ERROR("1130003", "上传文件为空"),
    IMAGE_UPLOAD_SIZE_ERROR("1130004", "文件大小超过了最大限制！"),
    IMAGE_UPLOAD_TYPE_ERROR("1130005", "文件类型有误"),
    IMAGE_UPLOAD_ERROR("1130006", "上传文件异常"),

    PRODUCT_OPERATOR_ERROR("1140001", "商品操作异常"),
    PRODUCT_SEARCH_ERROR("1140002", "商品查询异常"),


    EXC_ERROR_PARAM_SYSTEM("1150000","无效的参数"),
    EXCEPTION_USER_REGISTER("1150001", "用户注册异常"),
    EXCEPTION_USER_IDENTITY("1150002","获取用户信息异常"),
    EXCEPTION_OPERATOR_WEPHONE_ERROR("115003","获取用户微信授权手机号异常"),
    EXCEPTION_OPERATOR_LOGIN_FAIL("115004","登录异常"),
    SHOPCART_SEARCH_ERROR("1160001", "购物车查询异常"),
    SHOPCART_OPERATOR_ERROR("1160002", "购物车操作异常")
    ;

    private Object code;

    private Object value;

    private ConstantEnum(Object code, Object value) {
        this.code = code;
        this.value = value;
    }

    /**	
     * @Description: 获取code byte类型值,请确保该值可转换为byte值，否则会类型转换异常 
     * @return	
     * @Author:  柯军
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Byte getCodeByte() {
        return Integer.valueOf(code.toString()).byteValue();
    }

    
    /**	
     * @Description: 获取code int类型值,请确保该值可转换为int值，否则会类型转换异常 
     * @return	
     * @Author:  柯军
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Integer getCodeInt() {
        return Integer.valueOf(code.toString());
    }
    
    /**	
     * @Description: 获取code String类型值
     * @return	
     * @Author:  柯军
     * @datetime:2015年5月19日下午3:53:36
     **/
    public String getCodeStr() {
        return code.toString();
    }
    /**	
     * @Description:  获取value byte类型值,请确保该值可转换为byte值，否则会类型转换异常 
     * @return	
     * @Author:  柯军
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Byte getValueByte() {
        return Integer.valueOf(value.toString()).byteValue();
    }

    /**	
     * @Description:  获取value int类型值,请确保该值可转换为int值，否则会类型转换异常 
     * @return	
     * @Author:  柯军
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Integer getValueInt() {
        return Integer.valueOf(value.toString());
    }
    
    /**	
     * @Description: 获取value String类型值 
     * @return	
     * @Author:  柯军
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
