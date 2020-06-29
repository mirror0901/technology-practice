package com.mirror.base.designmode.chainmodel;

/**
 * @author: mirror
 * @date: 2020/4/22 16:13
 * @description:
 */
public class LiabilityChain {

    public void runChain() {

        Task task3 = new Task3();
        Task task2 = new Task2(task3);
        Task task1 = new Task1(task2);
        task1.run();

    }

}
