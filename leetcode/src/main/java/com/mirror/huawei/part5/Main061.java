package com.mirror.huawei.part5;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:计算两个字符串的最大公共字串的长度，字符不区分大小写
 * @create: 2020-05-23 17:11
 **/
public class Main061 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = s1.length() >= s2.length() ? s2 : s1;
            int l = 0;
            String s = "";
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {
                    if (max.contains(min.substring(i, j)) && j - i > l) {
                        l = j - i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s.length());
        }
        sc.close();
    }
}
