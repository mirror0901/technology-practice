package com.mirror.ormtransaction.utils;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 管理事务的开发，回滚，关闭
 * @create: 2020-06-23 01:29
 **/
@Component
public class MTranstionManager {

    /**
     * 开始事务
     *
     * @param connection
     */
    public void startTx(Connection connection) {
        try {
            if (connection != null) {
                connection.setAutoCommit(Boolean.FALSE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     *
     * @param connection
     */
    public void commitTx(Connection connection) {
        try {
            if (connection != null) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     *
     * @param connection
     */
    public void rollBackTx(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务
     *
     * @param connection
     */
    public void closeTx(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
