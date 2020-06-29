package com.mirror.base.classload;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-15 01:32
 **/
public class ConstClass {

    static {
        System.out.println("constclass init");
    }

    public static final String HELLOWORLD = "hello world!";

}
