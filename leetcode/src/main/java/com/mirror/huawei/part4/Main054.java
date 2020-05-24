package com.mirror.huawei.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 * @create: 2020-05-23 15:00
 **/
public class Main054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int maxRadio = 0;
            int index = 0;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i <= str.length() - n; i++) {
                int temp = getMaxRadio(str.substring(i, i + n));
                if (temp > maxRadio) {
                    maxRadio = temp;
                    index = i;
                }
            }
            System.out.println(str.substring(index, index + n));
        }
    }

    public static int getMaxRadio(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('G' == str.charAt(i) || 'C' == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

}
