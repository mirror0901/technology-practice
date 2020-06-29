package com.mirror.huawei.part2;


import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * <p>
 * 坐标之间以;分隔。
 * <p>
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * @create: 2020-05-16 21:47
 **/
public class Main019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int x = 0;
            int y = 0;
            final String[] tokens = sc.nextLine().split(";");
            for (int i = 0; i < tokens.length; i++) {
                try {
                    int b = Integer.parseInt(tokens[i].substring(1, tokens[i].length()));
                    if (tokens[i].charAt(0) == 'A') {
                        x -= b;
                    }
                    if (tokens[i].charAt(0) == 'W') {
                        y += b;
                    }
                    if (tokens[i].charAt(0) == 'S') {
                        y -= b;
                    }
                    if (tokens[i].charAt(0) == 'D') {
                        x += b;
                    }

                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println(x + "," + y);
        }
        sc.close();
    }
}