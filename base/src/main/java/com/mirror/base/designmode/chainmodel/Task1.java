package com.mirror.base.designmode.chainmodel;

/**
 * @author: mirror
 * @date: 2020/4/22 16:07
 * @description:
 */
public class Task1 implements Task {

    private Task task;

    public Task1() {
    }

    public Task1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task1 is run");
        if (task != null) {
            task.run();
        }
    }
}
