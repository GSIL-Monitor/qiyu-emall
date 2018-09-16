package com.qiyu.emall.dto;

public class MallUserAddressDto extends BaseMallDto{
    private static final long serialVersionUID = -2958899602318124472L;

    private Integer addressId;
    private String address;
    private Integer isDefault; // 0 默认地址 1非默认地址
    private String linkPhone;//联系电话
    private String linkName;//联系人姓名
    private Integer linkSex;//0 男 1 女
    private String label;//标签

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Integer getLinkSex() {
        return linkSex;
    }

    public void setLinkSex(Integer linkSex) {
        this.linkSex = linkSex;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "MallUserAddressDto{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", isDefault=" + isDefault +
                ", linkPhone='" + linkPhone + '\'' +
                ", linkName='" + linkName + '\'' +
                ", linkSex=" + linkSex +
                ", label='" + label + '\'' +
                '}';
    }
}
