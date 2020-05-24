package com.mirror.huawei.part5;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * @create: 2020-05-23 17:43
 **/
public class Main062 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            scanner.nextLine();
            getString(input);
        }
        scanner.close();
    }

    public static void getString(int input) {
        // first Num format
        int curNum = input * (input - 1) + 1;
        StringBuffer sBuffer = new StringBuffer();
        // build string
        for (int i = 0; i < input; i++) {
            if (i == input - 1) {
                sBuffer.append(curNum);
            } else {
                sBuffer.append(curNum + "+");
            }
            curNum += 2;
        }
        System.out.println(sBuffer);
    }

}
