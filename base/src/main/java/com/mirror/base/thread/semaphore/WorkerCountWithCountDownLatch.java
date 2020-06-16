package com.mirror.base.thread.semaphore;

import java.util.concurrent.CountDownLatch;

/**
 * @author: mirror
 * @date: 2020/6/16 11:04
 * @description: 场景:流水线上有3个worker:worker1,worker2,worker3,
 * 只有当 worker1和worker2执行完成时才可以执行worker3
 */
public class WorkerCountWithCountDownLatch extends Thread {

    private String name;

    private long time;

    private CountDownLatch countDownLatch;

    public WorkerCountWithCountDownLatch(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "工作完成,耗时:" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount():" + countDownLatch.getCount());
        }
    }

    public static void main(String[] args) throws Exception {
        int COUNT = 2;
        final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        WorkerCountWithCountDownLatch worker0 = new WorkerCountWithCountDownLatch("lilei-0", (long) (Math.random() * 1000), countDownLatch);
        WorkerCountWithCountDownLatch worker1 = new WorkerCountWithCountDownLatch("lilei-1", (long) (Math.random() * 1000), countDownLatch);
        worker0.start();
        worker1.start();
        countDownLatch.await();
        System.out.println("准备工作就绪");

        WorkerCountWithCountDownLatch worker2 = new WorkerCountWithCountDownLatch("lilei-2", (long) (Math.random() * 1000), countDownLatch);
        worker2.start();

        WorkerCountWithCountDownLatch worker3 = new WorkerCountWithCountDownLatch("lilei-3", (long) (Math.random() * 1000), countDownLatch);
        worker3.start();

        Thread.sleep(10000);
    }

}
