package huawei.part2;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 有一只兔子，从出生后第3个月起每个月都生一只兔子，
 * 小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * @analyze：这是一个典型的斐波那契数列问题，当月的兔子数=老兔子+新兔子，这里的老兔子就是上个月所有兔子， 而新兔子就是上上个月的所有兔子(到这个月有了生育能力)，
 * 即f(n)=f(n-1)+f(n-2)或者我们直接根据每月兔子数量也能得出这个结论：1 1 2 3 5 8...
 * @create: 2020-05-20 23:45
 **/
public class Main030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final int monthCount = Integer.parseInt(scanner.nextLine());
            System.out.println(getTotalCount1(monthCount));
        }
    }

    private static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < monthCount; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    private static int getTotalCount1(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        } else {
            return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
        }
    }

}
