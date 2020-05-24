package com.mirror.huawei.part6;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 在字符串中找到连续最长的数字串
 * @create: 2020-05-23 20:50
 **/
public class Main076 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = "";
            String str = scan.nextLine();
            for (char ch : str.toCharArray()) {
                //将不是数字的字符全部变成a
                if (ch >= '0' && ch <= '9') {
                    str1 += ch;
                } else {
                    str1 += "a";
                }
            }
            //按a分割
            String[] strs = str1.split("a");
            int max = 0;//记录最长的连续数字串的长度
            for (int i = 0; i < strs.length; i++) {
                max = strs[i].length() > max ? strs[i].length() : max;
            }
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == max)
                    System.out.print(strs[i]);
            }
            System.out.println("," + max);
        }
    }
}
