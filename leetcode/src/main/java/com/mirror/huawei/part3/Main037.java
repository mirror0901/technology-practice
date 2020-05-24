package com.mirror.huawei.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: TODO:
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，
 * 推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 * @create: 2020-05-22 23:49
 **/
public class Main037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null && str.length() > 0) {
            int[][] sudoku = new int[9][9];
            String[] data = str.split(" ");
            for (int i = 0; i < 9; i++) {
                sudoku[0][i] = Integer.parseInt(data[i]);
            }
            for (int i = 1; i < 9; i++) {
                str = br.readLine();
                data = str.split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(data[j]);
                }
            }
            find(sudoku, 0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]);
                    if (j < 8) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * 深度遍历
     *
     * @param matrix
     * @param count
     * @return
     */
    public static boolean find(int[][] matrix, int count) {
        int x = count / 9;
        int y = count % 9;
        //到达终点，遍历完成
        if (count > 80) {
            return true;
        }
        if (matrix[x][y] != 0) {
            return find(matrix, count + 1);
        } else {
            ArrayList<Integer> list = jie(matrix, x, y);
            while (!list.isEmpty()) {
                matrix[x][y] = list.remove(0);
                if (find(matrix, count + 1)) {
                    return true;
                } else {
                    matrix[x][y] = 0;
                }
            }
        }
        return false;
    }

    /**
     * 判断某个位置可以放那些值
     *
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    public static ArrayList<Integer> jie(int[][] matrix, int x, int y) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //行元素
        List<Integer> list1 = new ArrayList<Integer>();
        //列元素
        List<Integer> list2 = new ArrayList<Integer>();
        //粗线宫元素
        List<Integer> list3 = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            list1.add(matrix[x][i]);
            list2.add(matrix[i][y]);
        }
        int m = x / 3;
        int n = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list3.add(matrix[m * 3 + i][n * 3 + j]);
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!(list1.contains(i) || list2.contains(i) || list3.contains(i))) {
                list.add(i);
            }
        }
        return list;
    }

}
