package com.qiyu.emall.common.core.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品vo
 */
@Data
public class BannerVo implements Serializable {
    private static final long serialVersionUID = -2632153579506390912L;
    private Integer bannerId;//商品id
    private String picture;//商品图片
    private Integer type;// 1商品
    private String typeVal;//对应type的值
    private String name;
    private String url;
    private Integer sort;// sort 越小排越前
    private Integer status;//(0:显示,1:隐藏 2 删除)
    private Long createAt;
    private String createUser;
    private Long updateAt;
    private String updateUser;
}
