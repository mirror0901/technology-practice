package com.mirror.base.thread.semaphore;

import java.util.concurrent.CountDownLatch;

/**
 * @author: mirror
 * @date: 2020/6/16 13:39
 * @description: countdownLatch和join的区别在哪?
 * 场景: 流水线上有3个worker:worker1,worker2,worker3,
 * 只有当worker1和worker2两者的阶段一都执行完成后才可以执行worker3
 * 此时用join无法实现,只能用countDownLatch
 */
public class WorkerCountWithCountDownLatch1 extends Thread {

    private String name;

    private long time;

    private CountDownLatch countDownLatch;

    public WorkerCountWithCountDownLatch1(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始阶段1工作");
            Thread.sleep(time);

            System.out.println(name + "阶段1完成,耗时:" + time);
            countDownLatch.countDown();

            System.out.println(name + "开始阶段2工作");
            Thread.sleep(time);
            System.out.println(name + "阶段2完成,耗时:" + time);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int COUNT = 2;
        final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        WorkerCountWithCountDownLatch1 worker0 = new WorkerCountWithCountDownLatch1("lilei-0", (long) (Math.random() * 10000), countDownLatch);
        WorkerCountWithCountDownLatch1 worker1 = new WorkerCountWithCountDownLatch1("lilei-1", (long) (Math.random() * 10000), countDownLatch);
        worker0.start();
        worker1.start();

        countDownLatch.await();
        System.out.println("准备工作就绪");
        WorkerCountWithCountDownLatch1 worker2 = new WorkerCountWithCountDownLatch1("lilei-1", (long) (Math.random() * 10000), countDownLatch);
        worker2.start();
        Thread.sleep(10000);

    }

}
