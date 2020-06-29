package com.mirror.base.classload;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-15 01:31
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("subclass init");
    }

}
