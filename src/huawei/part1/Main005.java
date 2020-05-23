package huawei.part1;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * @create: 2020-05-16 21:47
 **/
public class Main005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next().substring(2);
            System.out.println(Integer.parseInt(str, 16));
        }
    }

}
