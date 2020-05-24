package com.mirror.huawei.part3;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * @create: 2020-05-21 02:00
 **/
public class Main033 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String str = scanner.nextLine();
            int[] count = new int[4];
            for (int i = 0; i < str.length(); i++) {
                final char c = str.charAt(i);
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    count[0]++;
                } else if (c == ' ') {
                    count[1]++;
                } else if (c >= '0' && c <= '9') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }
            for (int i = 0; i < 4; i++) {
                System.out.println(count[i]);
            }
        }
        scanner.close();
    }

}
