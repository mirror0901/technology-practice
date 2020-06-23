package com.mirror.ormtransaction.utils;

import com.mirror.ormtransaction.annotation.MTransction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 采用AOP来给自定义注解赋予意义
 * @create: 2020-06-23 00:38
 **/
@Component
@Aspect
public class MAopAspect {

    /**
     * 注入获取连接
     */
    @Autowired
    private MTransitionHolder transitionHolder;

    /**
     * 注入事务管理
     */
    @Autowired
    private MTransitionManager transitionManager;

    /**
     * 说明：
     * 1 使用 @Around 环绕执行 执行前和执行后
     * 2 采用 @annotation 使用了 MTransction 注解类执行此方法
     * 3 获取连接，这样保证被 MTransction 注解的方法采用了同一个连接 connection
     * 4 同一个 connection 共有一个事务，如果失败，则全部回滚
     *
     * @param proceedingJoinPoint
     * @param mTransction
     * @return
     */
    @Around(value = "@annotation(mTransction)")
    public Object txAroundOption(ProceedingJoinPoint proceedingJoinPoint, MTransction mTransction) {
        //开始获取连接
        Connection connection = transitionHolder.getConnection();

        Object proceed = null;

        try {
            //开始执行前开启事务管理
            transitionManager.startTx(connection);

            //开始执行操作
            proceed = proceedingJoinPoint.proceed();

            //执行之后提交事务
            transitionManager.commitTx(connection);

        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            transitionManager.rollBackTx(connection);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //回滚事务
            transitionManager.rollBackTx(connection);
        } finally {
            //关闭事务
            transitionManager.closeTx(connection);
        }

        return proceed;
    }

}
