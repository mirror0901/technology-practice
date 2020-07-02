package com.mirror.base.jvm.oom;

import java.util.Map;
import java.util.Random;

/**
 * @author: mirror
 * @date: 2020/7/2 15:32
 * @description: 垃圾回收超时内存溢出
 * 1、问题描述
 * 当应用程序耗尽所有可用内存时，GC开销限制超过了错误，而GC多次未能清除它，这时便会引发java.lang.OutOfMemoryError。
 * 当JVM花费大量的时间执行GC，而收效甚微，
 * 而一旦整个GC的过程超过限制便会触发错误(默认的jvm配置GC的时间超过98%，回收堆内存低于2%)。
 * 2.解决方法
 * 要减少对象生命周期，尽量能快速的进行垃圾回收。
 */
public class OverheadLimitOomError {

    public static void main(String[] args) {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "QQ:1755496180");
        }
    }

}
