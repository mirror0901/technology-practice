package com.mirror.base.thread.threadcommunication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: mirror
 * @date: 2020/4/24 20:48
 * @description: 方式五：基本LockSupport实现线程间的阻塞和唤醒
 */
public class TestSync5 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //实现线程B
        final Thread threadB = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("线程B收到通知,开始执行自己的业务");
        });
        //实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5)
                    LockSupport.unpark(threadB);
            }
        });
        threadA.start();
        threadB.start();
    }

}
