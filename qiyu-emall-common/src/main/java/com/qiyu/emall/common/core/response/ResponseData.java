package com.qiyu.emall.common.core.response;

import com.google.gson.Gson;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import lombok.Data;
/*
 * 返回示例说明
 * {
 *      "meta": {
 *          "msg": "success",   //返回的是错误提示信息
 *          "errno": "0"        //0代表成功  1，代表失败
 *      },
 *      "result": {} or [],     //多行记录返回数组
 *      "page":{                //page 是可选项，data为数组时才会有page，也可以无page信息（不分页）。
 *          "currentPage"":1 ,  //当前页,目前系统有从0或1开始。统一1开始
 *          "pageSize":10,      //分页的数量
 *          "totalCount":10     //总行数
 *      }
 * }
 */

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/13 下午5:47
 * Description: API接口返回统一数据结构
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/13      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
@Data
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 7765945407892921878L;
    private Meta meta; // errno=0：成功,errno=1:失败
    private T result;//数据
    private Page page;

    public ResponseData(Meta meta, T result, Integer currentPage, Integer pageSize, Integer totalCount) {
        this(meta, result, new Page(currentPage, pageSize, totalCount));
    }

    public ResponseData(Meta meta) {
        this.meta = meta;
    }

    public ResponseData(Meta meta, T result) {
        this.meta = meta;
        this.result = result;
    }

    public ResponseData(Meta meta, T result, Page page) {
        this.meta = meta;
        this.result = result;
        this.page = page;
    }

    public boolean isSuccess() {
        return meta != null && meta.isSuccess();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("meta", meta)
                .append("result", result)
                .toString();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}