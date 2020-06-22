package com.mirror.ormtransaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 自定义一个事务管理的工具类
 * @create: 2020-06-23 01:18
 **/
//交给spring去管理
@Component
public class MTransctionHolder {

    /**
     * 本来线程不安全的，通过ThreadLocal这么封装一下，立马就变成线程的局部变量，
     * 不仅仅安全了，还保证了一个线程下面的操作拿到的Connection是同一个对象
     */
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    @Autowired
    private MDataSource mDataSource;

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            if (threadLocal.get() == null) {
                final Connection connection = mDataSource.getConnection();
                threadLocal.set(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return threadLocal.get();
    }

}
