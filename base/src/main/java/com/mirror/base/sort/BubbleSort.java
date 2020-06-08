package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 10:59
 * @description: 冒泡排序 每次将最大的排到数组末尾
 * 时间复杂度：n^2 空间复杂度：1
 */
public class BubbleSort {

    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
