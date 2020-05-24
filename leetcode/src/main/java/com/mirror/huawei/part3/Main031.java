package com.mirror.huawei.part3;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?
 * 第5次反弹多高？
 * 最后的误差判断是小数点6位
 * @create: 2020-05-21 00:15
 **/
public class Main031 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int high = in.nextInt();
            System.out.println(getJourney(high));
            System.out.println(getTenthHigh(high));
        }
    }

    public static double getJourney(int high) {
        double highSum = 0;
        double high1 = high;
        for (int i = 1; i <= 5; i++) {
            highSum += high1 + high1 / 2;
            high1 /= 2;
        }
        highSum -= high1;
        return highSum;
    }

    public static double getTenthHigh(int high) {
        double high1 = high;
        for (int i = 1; i <= 5; i++) {
            high1 /= 2;
        }

        return high1;
    }

}
