package com.qiyu.emall.common.core.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品vo
 */
@Data
public class UserAddressVo implements Serializable {
    private static final long serialVersionUID = -4879217454931726583L;
    private Integer addressId;//地址id
    private String linkName;
    private String linkPhone;
    private Integer linkSex;
    private String address;
    private Integer isDefault;//(0:默认地址 1非默认地址)
    private Long createAt;
    private String createUser;
    private Long updateAt;
    private String updateUser;
}
