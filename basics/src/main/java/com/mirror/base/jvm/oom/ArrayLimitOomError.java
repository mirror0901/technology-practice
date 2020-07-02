package com.mirror.base.jvm.oom;

/**
 * @author: mirror
 * @date: 2020/7/2 16:23
 * @description: 数组超限内存溢出
 * <p>
 * 1.问题描述
 * 有的时候会碰到这种内存溢出的描述Requested array size exceeds VM limit，
 * 一般来说java对应用程序所能分配数组最大大小是有限制的，只不过不同的平台限制有所不同，
 * 但通常在1到21亿个元素之间。当Requested array size exceeds VM limit错误出现时，
 * 意味着应用程序试图分配大于Java虚拟机可以支持的数组。JVM在为数组分配内存之前，
 * 会执行特定平台的检查：分配的数据结构是否在此平台是可寻址的。
 * 2.解决方法
 * 因此数组长度要在平台允许的长度范围之内。不过这个错误一般少见的，主要是由于Java数组的索引是int类型。
 * Java中的最大正整数为2 ^ 31 - 1 = 2,147,483,647。 并且平台特定的限制可以非常接近这个数字，
 * 例如：我的环境上(64位macOS，运行Jdk1.8)可以初始化数组的长度高达2,147,483,645（Integer.MAX_VALUE-2）。
 * 若是在将数组的长度再增加1达到nteger.MAX_VALUE-1会出现的OutOfMemoryError
 */
public class ArrayLimitOomError {

    public static void main(String[] args) {

        for (int i = 3; i >= 0; i--) {
            try {
                int[] arr = new int[Integer.MAX_VALUE - i];
                System.out.format("初始化 %,d 元素", Integer.MAX_VALUE - i);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

    }

}
