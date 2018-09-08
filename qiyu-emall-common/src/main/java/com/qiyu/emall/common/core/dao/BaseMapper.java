package com.qiyu.emall.common.core.dao;


import com.qiyu.emall.common.core.entity.BaseEntity;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/11 下午6:18
 * Description: Mapper接口基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/11      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public interface BaseMapper<T extends BaseEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
