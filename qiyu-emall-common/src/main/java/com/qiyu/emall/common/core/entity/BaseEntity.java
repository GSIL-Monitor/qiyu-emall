package com.qiyu.emall.common.core.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/11 下午5:37
 * Description: 基础实体类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/11      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4732651363238889870L;
    /**
     * id
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 编辑时间
     */
    private Date updateAt;

    /**
     * 创建人id
     */
    private String createUser;

    /**
     * 修改人id
     */
    private String updateUser;

    /**
     * 备注描述
     */
    private String remark;

    public String toJson() {
        return new Gson().toJson(this);
    }

}
