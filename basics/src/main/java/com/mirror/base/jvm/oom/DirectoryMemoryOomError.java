package com.mirror.base.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: mirror
 * @date: 2020/7/2 16:02
 * @description: 直接内存内存溢出
 * 1.问题描述
 * 在使用ByteBuffer中的allocateDirect()的时候会用到，很多javaNIO(像netty)的框架中被封装为其他的方法，
 * 出现该问题时会抛出java.lang.OutOfMemoryError: Direct buffer memory异常。
 * 如果你在直接或间接使用了ByteBuffer中的allocateDirect方法的时候，而不做clear的时候就会出现类似的问题。
 * 2.解决办法
 * 如果经常有类似的操作，可以考虑设置参数：-XX:MaxDirectMemorySize，并及时clear内存。
 */
public class DirectoryMemoryOomError {

    static int ONE_MB = 1024 * 1024;
    static int index = 0;

    public static void main(String[] args) {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            while (true) {
                index++;
                unsafe.allocateMemory(ONE_MB);
            }
        } catch (Exception e) {
            System.out.println("index :" + index);
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("index :" + index);
            e.printStackTrace();
        }
    }

}
