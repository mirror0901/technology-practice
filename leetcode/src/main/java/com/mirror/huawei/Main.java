package com.mirror.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-23 21:53
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = 0;
            final String s = scanner.nextLine();

            if (isNum(s)) {
                List<String> zimu = new ArrayList<>();
                Integer integer = Integer.valueOf(s);
                countXiangshu(integer, zimu);
                Collections.reverse(zimu);
                StringBuilder stringBuilder = new StringBuilder();
                for (String strItem : zimu) {
                    stringBuilder.append(strItem);
                }
                System.out.println(stringBuilder.toString());
            } else {
                final char[] chars = s.toCharArray();
                final int length = chars.length;
                for (int i = 0; i < length; i++) {
                    int num = Integer.valueOf(chars[i]) - 96;
                    sum += num * Math.pow(26, length - i - 1);
                }
                System.out.println(sum);
            }
        }
        scanner.close();
    }

    private static void countXiangshu(int integer, List zimu) {
        int remaind = integer % 26;
        if (remaind > 0) {
            zimu.add((char) (96 + remaind) + "");
            integer = (integer - remaind) / 26;
            if (integer > 0) {
                countXiangshu(integer, zimu);
            }
        } else if (integer >= 26) {
            zimu.add("z");
            integer = (integer - 26) / 26;
            countXiangshu(integer, zimu);
        }
    }

    private static boolean isNum(String str) {
        boolean flag = false;
        final char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            if (aChar >= '0' && aChar <= '9') {
                flag = true;
            }
        }
        return flag;
    }

}
