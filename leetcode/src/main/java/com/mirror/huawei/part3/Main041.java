package com.mirror.huawei.part3;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，
 * 线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。
 * 要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。
 * @create: 2020-05-23 09:51
 **/
public class Main041 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final ExecutorService threadPoolhreadPol = Executors.newSingleThreadExecutor();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                threadPoolhreadPol.execute(new Task("A"));
                threadPoolhreadPol.execute(new Task("B"));
                threadPoolhreadPol.execute(new Task("C"));
                threadPoolhreadPol.execute(new Task("D"));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        threadPoolhreadPol.shutdown();
        scanner.close();
    }

}

class Task implements Runnable {
    public String output;

    public Task(String output) {
        this.output = output;
    }

    @Override
    public void run() {
        System.out.print(output);
    }
}