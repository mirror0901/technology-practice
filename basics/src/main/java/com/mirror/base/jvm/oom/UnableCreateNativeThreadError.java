package com.mirror.base.jvm.oom;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: mirror
 * @date: 2020/7/2 16:19
 * @description: 模拟无法创建本地线程, 抛出异常
 * 1.问题描述
 * 线程基本只占用heap以外的内存区域，也就是这个错误说明除了heap以外的区域，
 * 无法为线程分配一块内存区域了，这个要么是内存本身就不够，要么heap的空间设置得太大了，
 * 导致了剩余的内存已经不多了，而由于线程本身要占用内存，所以就不够用了。
 * 2.解决方法
 * 首先检查操作系统是否有线程数的限制，使用shell也无法创建线程，如果是这个问题就需要调整系统的最大可支持的文件数。
 * 日常开发中尽量保证线程最大数的可控制的，不要随意使用线程池。不能无限制的增长下去。
 */
public class UnableCreateNativeThreadError {

    public static void main(String[] args) {
        while (true) {
            Executor pool = Executors.newCachedThreadPool();
            pool.execute(() -> {
                System.out.println("aaaa");
            });
        }
    }

}
