package huawei;


import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * @create: 2020-05-16 21:47
 **/
public class Main017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int nextInt = sc.nextInt();
        while (nextInt > 0) {
            if ((nextInt & 1) > 0) {
                count++;
            }
            nextInt = nextInt >> 1;
        }
        System.out.println(count);
        sc.close();
    }
}