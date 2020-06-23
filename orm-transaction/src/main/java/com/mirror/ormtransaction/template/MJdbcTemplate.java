package com.mirror.ormtransaction.template;

import com.mirror.ormtransaction.common.InvokeClassAdapter;
import com.mirror.ormtransaction.utils.MTransitionHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 具体执行数据库操作
 * @create: 2020-06-23 23:13
 **/
@Component
public class MJdbcTemplate<T> {

    @Autowired
    private MTransitionHolder mTransitionHolder;

    @Autowired
    private InvokeClassAdapter invokeClassAdapter;

    /**
     * 执行具体的操作（查询）,并且返回实体类
     *
     * @param sql
     * @param clazz
     * @param list
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T executeQueryStatement(StringBuffer sql, Class<T> clazz, List<Object> list) throws IllegalAccessException, InstantiationException {
        T instance = null;
        Connection connection = mTransitionHolder.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            System.out.println("查询sql" + sql.toString());
            if (null != list && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setObject(i + 1, list.get(i));
                    System.out.println("参数" + i + ":" + list.get(i));
                }
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                instance = (T) invokeClassAdapter.invokeObject(resultSet, clazz);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * 查询结果返回集合
     *
     * @param sql
     * @param entity
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<T> executeQueryStatementByList(StringBuffer sql, Class<T> entity) throws IllegalAccessException, InstantiationException {
        T instance = null;
        List<T> instanceList = new ArrayList<>();
        Connection connection = mTransitionHolder.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                instance = (T) invokeClassAdapter.invokeObject(resultSet, entity);
                instanceList.add(instance);
            }
            return instanceList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    /**
     * 执行具体的操作（增，改）
     *
     * @param sql
     * @param paramsList
     * @return
     */
    public boolean executeStatement(StringBuffer sql, List<Object> paramsList) {
        Connection connection = mTransitionHolder.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            if (paramsList != null && paramsList.size() > 0) {
                for (int i = 0; i < paramsList.size(); i++) {
                    preparedStatement.setObject(i + 1, paramsList.get(i));
                }
            }
            boolean execute = preparedStatement.execute();
            if (execute) {
                return Boolean.TRUE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        } finally {
            try {
                preparedStatement.close();
                //因为此处和AOP中使用的connection是同一个，所以此处不能关闭connection，只关闭preparedStatement即可
                //connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Boolean.FALSE;
    }

}
