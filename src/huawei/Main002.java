package huawei;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
 * 然后输出输入字符串中含有该字符的个数。不区分大小写。
 * @create: 2020-05-16 17:33
 **/
public class Main002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String str = scanner.nextLine();
        final String stringChar = scanner.nextLine();
        int count = 0;
        final String[] split = str.split("");
        for (int i = 0, len = split.length; i < len; i++) {
            if (split[i].equalsIgnoreCase(stringChar)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
