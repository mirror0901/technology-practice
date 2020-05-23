package huawei.part4;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:查找输入整数二进制中1的个数
 * @create: 2020-05-23 14:37
 **/
public class Main053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int ans = findNumberOf1(n);
            System.out.println(ans);
        }
        scanner.close();
    }

    public static int findNumberOf1(int num) {
        final String s = Integer.toBinaryString(num);
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') ans++;
        }
        return ans;
    }

}
