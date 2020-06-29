package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 15:02
 * @description:TODO 希尔排序
 * 时间复杂度 n^2  空间复杂度 1
 */
public class ShellSort {

    private void shellSort(int[] a) {
        int d = a.length;
        while (d > 0) {
            for (int i = d; i < a.length; i++) {
                int j = i;
                int temp = a[j];
                //应拿当前操作数进行比较
                while (j >= d && temp < a[j - d]) {
                    a[j] = a[j - d];
                    j -= d;
                }
                a[j] = temp;
            }
            d /= 2;
        }
    }

}
