package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 15:07
 * @description: TODO
 * 归并排序
 * 分成有序子列(长度为1任务有序)再合并 分阶段
 * 时间复杂度 nlog2n 空间复杂度 n
 */
public class MergeSort {

    private void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    /**
     * 合并阶段
     */
    private void merge(int[] a, int low, int mid, int high) {
        //申请一个合并后的空间
        int[] temp = new int[high - low + 1];
        // i/j: 两个待合并数组的指针 t: 合并后数组指针
        int i = low, j = mid + 1, t = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        //肯定只会走一个while循环：若其中一个数组还有未加入合并数组的 则直接加入
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= high) {
            temp[t++] = a[j++];
        }
        //将临时数组里的数据复制到原数组 注意指针是k+low
        for (int k = 0; k < temp.length; k++) {
            a[k + low] = temp[k];
        }
    }

}
