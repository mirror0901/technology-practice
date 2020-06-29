package com.mirror.ormtransaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 自定义字段和属性的映射关系注解
 * @create: 2020-06-22 01:46
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MColumn {

    String columnName() default "";

}
