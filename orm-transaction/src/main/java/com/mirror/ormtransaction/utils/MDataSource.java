package com.mirror.ormtransaction.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 数据源定义
 * @create: 2020-06-23 00:45
 **/
@Component
@PropertySource(value = "classpath:/application.properties")
public class MDataSource {

    @Value("${spring.datasource.driver}")
    public String driver;

    @Value("${spring.datasource.url}")
    public String url;

    @Value("${spring.datasource.username}")
    public String username;

    @Value("${spring.datasource.password}")
    public String password;

    /**
     * 加载驱动器
     */
    @PostConstruct
    public void initDriver() {
        try {
            Driver drivers = (Driver) Class.forName(driver).newInstance();
            //把这个驱动器注册到驱动管理器内
            DriverManager.registerDriver(drivers);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
