package com.mirror.huawei.part1;


import java.util.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入一个整数，将这个整数以字符串的形式逆序输出
 * <p>
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * @create: 2020-05-16 21:47
 **/
public class Main013 {

    public static void main(String[] args) {
        List<Character> set = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = str.length() - 1; i >= 0; i--) {
            set.add(str.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character item : set) {
            stringBuilder.append(item);
        }
        System.out.println(stringBuilder);
        sc.close();
    }

}