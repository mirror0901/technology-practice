package com.mirror.huawei.part3;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * TODO
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。
 * 利用子网掩码可以判断两台主机是否中同一子网中。
 * 若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中
 * @create: 2020-05-21 01:41
 **/
public class Main032 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String mask = scanner.nextLine();
        final String ip1 = scanner.nextLine();
        final String ip2 = scanner.nextLine();
        System.out.println(judge(mask, ip1, ip2));
    }

    private static int judge(String mask, String ip1, String ip2) {
        final String[] split = ip1.split("\\.");
        if (split.length != 4) {
            return 1;
        }
        for (int i = 0; i < split.length - 1; i++) {
            if (Integer.valueOf(split[i]) > 255 || Integer.valueOf(split[i]) < 0) {
                return 1;
            }
        }
        return 0;
    }

}
