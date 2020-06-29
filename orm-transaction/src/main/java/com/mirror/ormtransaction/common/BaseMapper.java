package com.mirror.ormtransaction.common;

import com.mirror.ormtransaction.template.MJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 定义抽象类, 用来封装ORM数据映射
 * @create: 2020-06-24 00:32
 **/
public class BaseMapper<T> {

    @Autowired
    private BuildParamToFieldManager<T> buildParamToFieldManager;

    @Autowired
    private MJdbcTemplate mJdbcTemplate;

    /**
     * 保存实体
     *
     * @param t
     * @return
     */
    public boolean add(T t) {

        //定义sql
        StringBuffer sql = new StringBuffer();

        //参数集
        List<Object> paramsList = new ArrayList<>();

        //开始拼接单表新增的sql（Object->Field）
        buildParamToFieldManager.buildInsertFieldParams(t, sql, paramsList);

        //开始执行具体的操作
        boolean b = mJdbcTemplate.executeStatement(sql, paramsList);

        return b;
    }

    /**
     * 删除某个实体
     *
     * @param id
     * @return
     */
    public boolean delete(Object id) {
        //定义sql
        StringBuffer sql = new StringBuffer();
        //参数集
        List<Object> paramsList = new ArrayList<>();
        //开始拼接sql（Object->Field）
        buildParamToFieldManager.buildDeleteFieldParams(buildParamToFieldManager.getClassInfo(this.getClass()), sql, paramsList, id);

        //执行sql操作
        boolean b = mJdbcTemplate.executeStatement(sql, paramsList);
        return b;
    }

    /**
     * 编辑某个实体
     *
     * @param t
     * @return
     */
    public boolean update(T t) {
        StringBuffer sql = new StringBuffer();
        //参数集
        List<Object> paramsList = new ArrayList<>();
        //开始拼接编辑的sql
        buildParamToFieldManager.buildUpdateFieldParams(t, sql, paramsList);
        //执行sql操作
        return mJdbcTemplate.executeStatement(sql, paramsList);
    }

    /**
     * 查询某个实体
     *
     * @param id
     * @return
     */
    public T query(Object id) {

        StringBuffer sql = new StringBuffer();
        List<Object> paramList = new ArrayList<>();
        Class<T> classInfo = buildParamToFieldManager.getClassInfo(this.getClass());

        try {
            buildParamToFieldManager.buildSelectFieldParams(classInfo.newInstance(), sql, id, paramList);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        T entity = null;
        try {
            //执行查询具体操作，并且将（sql->Object）,最终将查询结果再次反转化为Object返回
            entity = (T) mJdbcTemplate.executeQueryStatement(sql, classInfo, paramList);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll() {

        StringBuffer sql = new StringBuffer();
        List<Object> paramList = new ArrayList<>();
        //获取当前类的实体类
        Class<T> classInfo = buildParamToFieldManager.getClassInfo(this.getClass());

        try {
            //开始拼接查询的sql（Object->Field）
            buildParamToFieldManager.buildSelectFieldParams(classInfo.newInstance(), sql, null, paramList);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<T> list = null;
        try {
            //执行具体的操作,并且最终将数据库中查询出来的数据封装成实体类的集合返回
            list = mJdbcTemplate.executeQueryStatementByList(sql, classInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

}
