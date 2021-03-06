package com.mirror.huawei.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 * @create: 2020-05-23 00:06
 **/
public class Main039 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        String str1 = "";
        String str2 = "";
        while ((string = br.readLine()) != null) {
            String[] ssString = string.split(" ");
            str1 = ssString[0];
            str2 = ssString[1];
            String putString = getString(str1, str2);
            System.out.println(putString);
        }
    }

    public static String getString(String str1, String str2) {
        int num = 0;
        int count = Integer.parseInt(str2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num < count; i++) {
            if ((str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') || (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z')) {
                num++;
            } else {
                if (num == count - 1) {
                    num += 2;
                    break;
                } else {
                    num += 2;
                }
            }
            sb.append(str1.charAt(i));
        }
        return sb.toString();
    }

}
