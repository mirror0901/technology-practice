package com.mirror.ormtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-25 17:36
 **/
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public void addData() throws SQLException {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            final Statement statement = connection.createStatement();
            System.out.println("=== 开启事务 ===");
            String sql = " insert into student(name,age,sex) value('mirror',12,'男') ";

            statement.execute(sql);
            System.out.println("开始执行第一条sql");

            String sql2 = "insert into student(name,age,sex) value('mirror',22,'男')";
            statement.execute(sql2);
            System.out.println("开始执行第二条sql");
            //int i = 1 / 0;
            connection.commit();
            System.out.println("事务提交");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("事务回滚");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("连接关闭");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}