package com.mirror.huawei.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器计算机中，
 * 参与运算的操作数和结果必须在-2^31~2^31-1之间。如果需要进行更大范围的十进制整数加法，需要使用特殊
 * 的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。如下：
 * 9876543210 + 1234567890 = ?
 * 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result = "11111111100"。
 * -9876543210 + (-1234567890) = ?
 * 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result = "-11111111100"。
 * @create: 2020-05-23 14:07
 **/
public class Main048 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            BigInteger a = new BigInteger(str.trim());
            BigInteger b = new BigInteger(bf.readLine().trim());
            System.out.println(a.add(b).toString());
        }
        bf.close();
    }

}
