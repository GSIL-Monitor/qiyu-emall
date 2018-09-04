package com.qiyu.emall.enums;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/14 下午4:32
 * Description: 打印提交状态枚举类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/14      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public enum CommitStatusEnum {
    /**
     * 提交状态(1:提交成功,-1:提交失败,0:未提交)
     */
    STATUS_SUCCESS(1, "提交成功"),
    STATUS_FAIL(-1, "提交失败"),
    STATUS_NOT_COMMIT(0, "未提交");

    private Integer value;
    private String description;

    CommitStatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer value() {
        return value;
    }

    public String description() {
        return description;
    }

    public static CommitStatusEnum valueOf(Integer value) {
        for (CommitStatusEnum type : CommitStatusEnum.values()) {
            if (type.value().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
