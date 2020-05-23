package huawei.part4;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:找出字符串中第一个只出现一次的字符
 * @create: 2020-05-23 14:17
 **/
public class Main050 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                String s = ch + "";
                if ((n - str.replaceAll(s, "").length()) == 1) {
                    System.out.println(str.charAt(i));
                    break;
                }
            }
        }

    }

}
