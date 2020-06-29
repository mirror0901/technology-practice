package com.mirror.base.thread.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: mirror
 * @date: 2020/6/16 10:31
 * @description: 场景: 模拟10人赛跑.10人跑完后才喊"Game Over."
 * 分析: 代码中定义了2个计数器,个数分别为 1 和 10
 * 如果不执行 begin.countDown(),进程会一直阻塞在begin.await()
 * 主进程执行到 end.await()阻塞等待end计数器清0,进程中每执行一次CountDown()减1,
 * 所有执行完后主进程继续往下执行
 * 注意: countDown() 一定要执行到 (考虑异常及线程与开始计数设置不一致),
 * 否则会一直卡在await()(可以设置时间,超过一定时间就不等了)
 */
public class CountDownLatchTest {

    private static final int RUNNER_COUNT = 10;

    public static void main(String[] args) throws Exception {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
        final ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < RUNNER_COUNT; i++) {
            final int NO = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            threadPool.submit(runnable);
        }

        System.out.println("Game Start ……");
        begin.countDown();
        end.await();
        System.out.println("Game Over.");

        threadPool.shutdown();
    }

}
