package com.mirror.base.thread.semaphore;

/**
 * @author: mirror
 * @date: 2020/6/16 13:21
 * @description:
 */
public class WorkerCountWithJoin extends Thread {

    private String name;

    private long time;

    public WorkerCountWithJoin(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "工作完成,耗时:" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WorkerCountWithJoin workerCountWithJoin0 = new WorkerCountWithJoin("lilei-0", (long) (Math.random()) * 10000);
        WorkerCountWithJoin workerCountWithJoin1 = new WorkerCountWithJoin("lilei-1", (long) (Math.random()) * 10000);
        WorkerCountWithJoin workerCountWithJoin2 = new WorkerCountWithJoin("lilei-2", (long) (Math.random()) * 10000);
        workerCountWithJoin0.start();
        workerCountWithJoin1.start();

        workerCountWithJoin0.join();
        workerCountWithJoin1.join();
        System.out.println("准备工作就绪");

        workerCountWithJoin2.start();
        Thread.sleep(10000);

    }

}
