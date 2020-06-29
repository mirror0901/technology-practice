package com.mirror.base.designmode.chainmodel;

/**
 * @author: mirror
 * @date: 2020/4/22 16:07
 * @description:
 */
public class Task3 implements Task {

    private Task task;

    public Task3() {
    }

    public Task3(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task3 is run");
        if (task != null) {
            task.run();
        }
    }
}
