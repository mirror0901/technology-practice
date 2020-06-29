package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 14:36
 * @description: TODO
 * 快速排序 取基准值 使左侧比其小右侧比其大 递归
 * 时间复杂度 nlog2n 空间复杂度 nlog2n
 */
public class FastSort {

    private void fastSort(int[] array, int low, int high) {
        //递归出口
        if (low > high) {
            return;
        }
        int i = low, j = high, temp, key = array[low];
        while (i < j) {
            //一次交换两个非key值
            while (i < j && array[j] > key) {
                j--;
            }
            while (i < j && array[i] <= key) {
                i++;
            }
            if (i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //交换Key和中间位置
        temp = array[i];
        array[i] = array[low];
        array[low] = temp;
        //递归
        fastSort(array, low, i - 1);
        fastSort(array, i + 1, high);
    }

}
