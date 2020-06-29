package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 11:19
 * @description: 选择排序 每次选择一个最小的放到数组最前面
 * 时间复杂度:n^2 空间复杂度:1
 */
public class SelectSort {

    private void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //最小值索引
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                //交换最小值与array[i]
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

}
