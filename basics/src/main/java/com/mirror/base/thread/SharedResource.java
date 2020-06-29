package com.mirror.base.thread;

/**
 * @author: mirror
 * @date: 2020/4/27 17:09
 * @description: 共享的资源类
 * 2个线程分别增加和减少相同次数
 * 如果最终结果为0则表示增加和减少操作是线程安全的
 * 如果最后结果不为0则表示增加和减少操作不是线程安全的
 */
public class SharedResource {

    /**
     * 共享的内存空间
     */
    private static int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized  void increase() {
        SharedResource.count++;
    }

    public synchronized void decrease() {
        SharedResource.count--;
    }

}
