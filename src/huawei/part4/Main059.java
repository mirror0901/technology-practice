package huawei.part4;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 根据输入的日期，计算是这一年的第几天。。
 * 详细描述：
 * 输入某年某月某日，判断这一天是这一年的第几天？。
 * @create: 2020-05-23 16:46
 **/
public class Main059 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final LocalDate of = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            final int dayOfYear = of.getDayOfYear();
            System.out.println(dayOfYear);
        }
    }

}
