package com.mirror.base.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 读写锁
 * @create: 2020-05-05 15:10
 **/
public class ReadWriteLockTest {

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                //获取到读锁不释放，是为了校验另一个获取读锁的线程可以执行，另一个获取写锁的线程不能执行
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                System.out.println("只可能因为sleep而中断……");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(1);

        new Thread(() -> {
            //获取读锁
            readWriteLock.readLock().lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("获取读锁，执行中..");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("只可能因sleep而中断...");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            //获取写锁
            readWriteLock.writeLock().lock();
            try {
                System.out.println("这句不能执行……");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }).start();

    }

}
