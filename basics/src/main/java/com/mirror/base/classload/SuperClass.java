package com.mirror.base.classload;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-15 01:30
 **/
public class SuperClass {
    static {
        System.out.println("superClass init!");
    }

    public static int value = 1127;
}
