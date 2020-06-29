package com.mirror.huawei.part1;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * @create: 2020-05-16 21:47
 **/
public class Main010 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = s.length(); i > 0; i--) {
            set.add(s.substring(i - 1, i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        final Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            stringBuilder = stringBuilder.append(iterator.next());
        }
        System.out.println(stringBuilder);
        scanner.close();
    }

}