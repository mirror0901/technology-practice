package com.mirror.huawei.part1;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * <p>
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * @create: 2020-05-16 17:32
 **/
public class Main001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strSplit = str.split("\\s+");
        int len = strSplit.length - 1;
        System.out.println(strSplit[len].length());
    }
}
