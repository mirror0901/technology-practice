package huawei;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @create: 2020-05-16 21:47
 **/
public class Main004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            split(s);
        }
    }

    public static void split(String s) {
        while (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            s = s.substring(8);
        }
        if (s.length() < 8 && s.length() > 0) {
            s = s + "00000000";
            System.out.println(s.substring(0, 8));
        }
    }

}
