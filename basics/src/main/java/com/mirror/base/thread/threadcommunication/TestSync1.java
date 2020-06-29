package com.mirror.base.thread.threadcommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror
 * @date: 2020/4/24 18:17
 * @description:题目：有两个线程A、B，A线程向一个集合里面依次添加元素"abc"字符串， 一共添加十次，当添加到第五次的时候，
 * 希望B线程能够收到A线程的通知，然后B线程执行相关的业务操作。
 * 方式一: 使用volatile关键字
 */
public class TestSync1 {

    //定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("adc");
                System.out.println("线程A向list中添加一个元素,此时list中的元素个数为:" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    notice = true;
                }
            }
        });
        //实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知,开始执行自己的业务……");
                    break;
                }
            }
        });
        //需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再启动线程A
        threadA.start();
    }

}
