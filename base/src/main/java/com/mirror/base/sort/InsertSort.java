package com.mirror.base.sort;

/**
 * @author: mirror
 * @date: 2020/6/8 11:05
 * @description: 插入排序 扑克牌排序
 * 时间复杂度: n^2 空间复杂度:1
 */
public class InsertSort {

    private void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insert = a[i];
            int j = i;
            //j>=1防止下标越界
            while (j >= 1 && a[j - 1] > insert) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = insert;
        }
    }

}
