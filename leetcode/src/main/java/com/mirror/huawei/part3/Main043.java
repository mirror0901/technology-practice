package com.mirror.huawei.part3;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * @create: 2020-05-23 10:34
 **/
public class Main043 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final int nextInt = scanner.nextInt();
            final Integer[] split = new Integer[nextInt];
            for (int i = 0; i < nextInt; i++) {
                split[i] = scanner.nextInt();
            }
            final int nextInt1 = scanner.nextInt();
            if (nextInt1 > 0 && nextInt - nextInt1 >= 0) {
                System.out.println(split[nextInt - nextInt1]);
            } else {
                System.out.println(0);
            }
        }
        scanner.close();
    }

}
