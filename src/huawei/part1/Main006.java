package huawei.part1;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * @create: 2020-05-16 21:47
 **/
public class Main006 {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        long num = str.nextLong();
        String result = getResult(num);
        System.out.println(result);
    }

    public static String getResult(long num) {
        int pum = 2;
        String result = "";
        while (num != 1) {
            while (num % pum == 0) {
                num = num / pum;
                result = result + pum + " ";
            }
            pum++;
        }
        return result;
    }

}
