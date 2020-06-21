package com.mirror.ormtransaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 自定义一个需要事务管理的注解
 * @create: 2020-06-22 01:46
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MTransction {

}
