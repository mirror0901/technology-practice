package huawei.part2;


import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，
 * 最多可以换多少瓶汽水喝？
 * @create: 2020-05-16 21:47
 **/
public class Main024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) break;
            int left = num;
            int total = 0;
            while (left != 0) {
                if (left == 2) {
                    total += 1;
                    break;
                } else if (left == 1) {
                    break;
                } else {
                    int curr = left / 3;
                    total += curr;
                    left = left - curr * 3 + curr;
                }
            }
            System.out.println(total);
        }
        sc.close();
    }

}