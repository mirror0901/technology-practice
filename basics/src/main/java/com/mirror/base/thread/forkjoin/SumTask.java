package com.mirror.base.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: fork-join我们可以理解为分而治之，就是说当一个任务非常大的时候，
 * 我们可以按照一定的业务需求拆分为若干个小的任务，最后把这些小的任务再聚合起来。
 * @create: 2020-05-05 16:32
 **/
public class SumTask extends RecursiveTask<Integer> {

    //阀值，当数组长度小于10就不再拆分
    private final static int THRESHOLD = 10;
    int[] array = null;
    int start;
    int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            //直接求和
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += this.array[i];
            }
            return sum;
        } else {
            //拆分
            int mid = (start + end) / 2;
            SumTask left = new SumTask(array, start, mid);
            SumTask right = new SumTask(array, mid + 1, end);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }

    /**
     * 注意
     * 1.如果有返回值就继承RecursiveTask，没有返回值就继承RecursiveAction
     * 2.上面是同步调用，如果想要异步调用，可以使用pool.execute(...);替换上面的invoke方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(arr, 0, arr.length - 1);
        pool.invoke(sumTask);
        System.out.println("完成，结果是:" + sumTask.join());
    }

}
