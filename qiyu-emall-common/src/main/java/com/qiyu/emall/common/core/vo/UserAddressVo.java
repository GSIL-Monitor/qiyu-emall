package com.qiyu.emall.common.core.vo;

import java.io.Serializable;


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


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Integer getLinkSex() {
        return linkSex;
    }

    public void setLinkSex(Integer linkSex) {
        this.linkSex = linkSex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
