package huawei.part2;


import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * @create: 2020-05-16 21:47
 **/
public class Main026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            final String s = sc.nextLine();
            int[] count = new int[26];
            int min = Integer.MAX_VALUE;
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                min = Math.min(min, count[c - 'a']);
            }
            String ret = "";
            for (char c : s.toCharArray()) {
                if (count[c - 'a'] != min) {
                    ret += c + "";
                }
            }
            System.out.println(ret);
        }
        sc.close();
    }

}