package com.mirror.base.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror
 * @date: 2020/7/2 14:59
 * @description: java堆内存溢出
 * 设置 VM options 为: -Xms20m -Xmx20m
 * 1.问题描述
 * 设置的jvm内存太小，对象所需内存太大，创建对象时分配空间，就会抛出这个异常。
 * 流量/数据峰值，应用程序自身的处理存在一定的限额，比如一定数量的用户或一定数量的数据。
 * 而当用户数量或数据量突然激增并超过预期的阈值时，
 * 那么就会峰值停止前正常运行的操作将停止并触发java . lang.OutOfMemoryError:Java堆空间错误
 * 2.解决方法
 * 首先，如果代码没有什么问题的情况下，可以适当调整-Xms和-Xmx两个jvm参数，使用压力测试来调整这两个参数达到最优值。
 * 其次，尽量避免大的对象的申请，像文件上传，大批量从数据库中获取，这是需要避免的，尽量分块或者分批处理，有助于系统的正常稳定的执行。
 * 最后，尽量提高一次请求的执行速度，垃圾回收越早越好，否则，大量的并发来了的时候，再来新的请求就无法分配内存了，就容易造成系统的雪崩。
 */
public class HeapOomError {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new byte[5 * 1024 * 1024]);
            System.out.println("count is: " + (++i));
        }
    }

}
