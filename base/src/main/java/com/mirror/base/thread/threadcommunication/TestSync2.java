package com.mirror.base.thread.threadcommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror
 * @date: 2020/4/24 19:31
 * @description: 方式二：使用Object类的wait() 和 notify() 方法
 * 众所周知，Object类提供了线程间通信的方法：wait()、notify()、notifyaAl()，它们是多线程通信的基础，而这种实现方式的思想自然是线程间通信。
 * 注意： wait和 notify必须配合synchronized使用，wait方法释放锁，notify方法不释放锁
 */
public class TestSync2 {

    public static void main(String[] args) {
        //定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程A向list中添加一个元素,此时list中的元素个数为: " + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5) {
                        //唤醒B线程,不释放锁
                        lock.notify();
                    }
                }
            }
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 5) {
                        try {
                            //System.out.println("线程B准备释放锁……");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知,开始执行自己的业务……");
                    break;
                }
            }
        });
        //需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再启动线程A
        threadA.start();
    }

}
