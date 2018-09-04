package com.qiyu.emall.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/14 下午5:00
 * Description: 打印接口返回数据结构
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/14      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PrinterResult extends BaseResult {
    private static final long serialVersionUID = 7606659468900194449L;

    /**
     * 打印数据提交状态
     * 1:成功
     * 2:提交超时 验证你所提交的时间戳超过3分钟后拒绝接受
     * 3:参数有误
     * 4:sign加密验证失败
     */
    private String state;

    private transient static final String SUCCESS = "1";

    public boolean isSuccess() {
        return SUCCESS.equalsIgnoreCase(state);
    }

    /**
     * 打印任务id
     */
    private String id;
}
