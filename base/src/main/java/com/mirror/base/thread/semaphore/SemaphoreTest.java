package com.mirror.base.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: mirror
 * @date: 2020/6/16 9:25
 * @description: semaphore是一个计数信号量, 它本质上是一个"共享锁"
 * 信号量维护了一个信号量许可集.线程可以通过调用acquire()来获取信号量;
 * 当信号量中有可用的许可时,线程能获取该许可;否则线程必须等待,直到有可用的许可为止.
 * 线程可以通过release()来释放它所持有的信号量许可.
 */
public class SemaphoreTest {

    private static final int SEM_MAX = 10;

    public static void main(String[] args) throws Exception {

        Semaphore sem = new Semaphore(SEM_MAX);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new MyThread(sem, 5));
        threadPool.execute(new MyThread(sem, 4));
        threadPool.execute(new MyThread(sem, 7));
        //关闭线程池
        threadPool.shutdown();

    }

}

class MyThread extends Thread {

    /**
     * 信号量
     */
    private volatile Semaphore sem;

    /**
     * 申请信号量的大小
     */
    private int count;

    MyThread(Semaphore sem, int count) {
        this.sem = sem;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            //从信号量中获取count个许可
            sem.acquire(count);

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " acquire count " + count);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放给定数目的许可,将其返回到信号量
            sem.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count + "");
        }
    }

}
