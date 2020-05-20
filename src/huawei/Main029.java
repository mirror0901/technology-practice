package huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 整数与IP地址间的转换
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
 * @create: 2020-05-16 21:47
 **/
public class Main029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = null;
        String line2 = null;
        while ((line1 = br.readLine()) != null && (line2 = br.readLine()) != null) {
            String[] IP1 = line1.split("\\.");
            long IP2 = Long.parseLong(line2);

            System.out.println(Long.parseLong(IP1[0]) << 24 | Long.parseLong(IP1[1]) << 16 |
                    Long.parseLong(IP1[2]) << 8 | Long.parseLong(IP1[3]));

            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf((IP2 >> 24) & 255)).append(".").append(String.valueOf((IP2 >> 16) & 255))
                    .append(".").append(String.valueOf((IP2 >> 8) & 255)).append(".").append(String.valueOf(IP2 & 255));
            System.out.println(sb.toString());

        }
    }

}