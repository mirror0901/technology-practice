package com.mirror.base.thread.threadproducerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: mirror
 * @date: 2020/4/27 14:29
 * @description:
 */
public class OrderStorage {

    /**
     * 使用阻塞队列作为仓库
     */
    private BlockingQueue<Order> queues;

    /**
     * 默认的仓库容量为50
     */
    public OrderStorage() {
        this.queues = new LinkedBlockingQueue<>(50);
    }

    /**
     * 初始化仓库容量
     *
     * @param capacity
     */
    public OrderStorage(int capacity) {
        this.queues = new LinkedBlockingQueue<>(capacity);
    }

    /**
     * 入库
     *
     * @param order
     * @throws InterruptedException
     */
    public void push(Order order) throws InterruptedException {
        queues.put(order);
    }

    /**
     * 出库
     *
     * @return
     * @throws InterruptedException
     */
    public Order pop() throws InterruptedException {
        //仓库中没元素时,会阻塞当前线程,直到元素可弹出
        return queues.take();
    }

}
