package huawei.part1;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整
 * @create: 2020-05-16 21:47
 **/
public class Main007 {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        double num = str.nextDouble();
        num = num += 0.5;
        System.out.println((int) num);
    }

}