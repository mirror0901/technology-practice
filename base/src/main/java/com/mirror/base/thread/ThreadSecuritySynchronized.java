package com.mirror.base.thread;

/**
 * @author: mirror
 * @date: 2020/4/27 17:05
 * @description: 模拟线程池, 启动多个线程驱动任务执行
 */
public class ThreadSecuritySynchronized {

    public static void main(String[] args) throws Exception {

        int cycleCount = 10000;
        //创建线程共享的内存资源
        SharedResource sharedResource = new SharedResource();
        //开启2个线程分别增加和减少共享资源的计数器
        Thread de = new Thread(() -> {
            for (int i = 0; i < cycleCount; i++) {
                sharedResource.decrease();
            }
        });

        Thread in = new Thread(() -> {
            for (int i = 0; i < cycleCount; i++) {
                sharedResource.increase();
            }
        });

        de.start();
        in.start();

        //线程联合,等de和in线程都执行完成后再继续执行
        de.join();
        in.join();

        System.out.println(sharedResource.getCount());

    }

}
