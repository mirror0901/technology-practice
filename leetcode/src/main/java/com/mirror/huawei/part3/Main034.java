package com.mirror.huawei.part3;

import java.util.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * @create: 2020-05-22 00:14
 **/
public class Main034 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //砝码种类
            int n = scanner.nextInt();
            int[] weights = new int[n];
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }
            int result = function(n, weights, numbers);
            System.out.println(result);
        }
        scanner.close();
    }

    public static int function(int n, int[] weights, int[] numbers) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i <= numbers[0]; i++) {
            set.add(i * weights[0]);
        }
        //从第二个砝码开始
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<>(set);
            //遍历砝码的个数
            for (int j = 1; j <= numbers[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + j * weights[i]);
                }
            }
        }
        return set.size();
    }

}
