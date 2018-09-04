package com.qiyu.emall.common.core.response;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/13 下午5:47
 * Description: API接口返回Meta字段结构
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/13      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    /**
     * 错误码
     */
    private String errno;
    /**
     * 错误提示信息
     */
    private String msg;

    public boolean isSuccess() {
        return "0".equalsIgnoreCase(errno);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("errno", errno)
                .append("msg", msg)
                .toString();
    }
}
