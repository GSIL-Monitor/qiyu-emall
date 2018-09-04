package com.qiyu.emall.common.core.response;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/13 下午5:52
 * Description: API接口返回Page字段结构
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/13      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    /**
     * 默认为第一页.
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页记录数(10).
     */
    public static final int DEFAULT_NUM_PER_PAGE = 10;

    /**
     * 当前第几页 默认从1开始
     */
    private Integer currentPage = DEFAULT_PAGE_NUM;//当前页：统一从1开始
    /**
     * 每页记录数
     */
    private Integer pageSize = DEFAULT_NUM_PER_PAGE; //每页行数
    /**
     * 总的记录数
     */
    private Integer totalCount; //总行数

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("currentPage", currentPage)
                .append("pageSize", pageSize)
                .append("totalCount", totalCount)
                .toString();
    }
}
