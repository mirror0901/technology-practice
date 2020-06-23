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

    public boolean add(T t) {

        //定义sql
        StringBuffer sql = new StringBuffer();

        //参数集
        List<Object> paramsList = new ArrayList<>();

        //开始拼接单表新增的sql（Object->Field）
        //buildParamToFieldManager
        return true;
    }

}
