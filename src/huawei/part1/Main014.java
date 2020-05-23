package huawei.part1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * @create: 2020-05-16 21:47
 **/
public class Main014 {

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