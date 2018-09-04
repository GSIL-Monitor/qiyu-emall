/*
package com.qiyu.emall.common.core.dao.impl;

import BaseMapper;
import BaseEntity;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

*/
/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/11 下午6:19
 * Description: 抽象Mapper实现类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/11      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 *//*

public abstract class AbstractBaseMapperImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseMapper<T> {
    private static final String SQL_INSERT = "insert";
    private static final String SQL_INSERT_SELECTIVE = "insertSelective";
    private static final String SQL_DELETE_BY_PRIMARY_KEY = "deleteByPrimaryKey";
    private static final String SQL_UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";
    private static final String SQL_UPDATE_BY_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
    private static final String SQL_SELECT_BY_PRIMARY_KEY = "selectByPrimaryKey";

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public String getStatement(String sqlId) {
        //决定了mapper.xml namespace中的值
        String name = this.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".").append(sqlId);
        return sb.toString();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete(getStatement(SQL_DELETE_BY_PRIMARY_KEY), id);
    }

    @Override
    public int insert(T record) {
        record.setCreateAt(new Date());
        return getSqlSession().insert(getStatement(SQL_INSERT), record);
    }

    @Override
    public int insertSelective(T record) {
        record.setCreateAt(new Date());
        return getSqlSession().insert(getStatement(SQL_INSERT_SELECTIVE), record);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return getSqlSession().selectOne(getStatement(SQL_SELECT_BY_PRIMARY_KEY), id);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record.setUpdateAt(new Date());
        return getSqlSession().update(getStatement(SQL_UPDATE_BY_PRIMARY_KEY), record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        record.setUpdateAt(new Date());
        return getSqlSession().update(getStatement(SQL_UPDATE_BY_PRIMARY_KEY_SELECTIVE), record);
    }



}
*/
