package com.qiyu.emall.common.core.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shaozhou on 2017/7/19.
 * 商品规格vo
 */
@Data
public class SpecAllVo implements Serializable {
    private List<ProductSpecVo> specVoList;
    private List<Integer> productIds;
}
