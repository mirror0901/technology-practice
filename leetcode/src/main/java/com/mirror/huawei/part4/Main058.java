package com.mirror.huawei.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * @create: 2020-05-23 16:39
 **/
public class Main058 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (bf.readLine() != null) {
            int a, b;
            for (a = 0; a < 20; a++) {
                for (b = 0; a + b < 35; b++) {
                    int c = 100 - a - b;
                    if (c % 3 == 0 && (100 - 5 * a - 3 * b) == c / 3) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
    }
}
