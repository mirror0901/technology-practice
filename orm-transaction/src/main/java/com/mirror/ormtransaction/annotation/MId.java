package com.mirror.ormtransaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 自定义主键的注解
 * @create: 2020-06-22 01:46
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MId {

    String idName() default "";

}
