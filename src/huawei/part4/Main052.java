package huawei.part4;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放， 问共有多少种不同的分法？
 * （用K表示）5，1，1和1，5，1 是同一种分法。
 * @create: 2020-05-23 14:31
 **/
public class Main052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(F(m, n));
        }
    }

    public static int F(int x, int y) {
        if (x == 0 || y == 1) {
            return 1;
        } else if (x < y) {
            return F(x, x);
        } else {
            return F(x, y - 1) + F(x - y, y);
        }
    }

}
