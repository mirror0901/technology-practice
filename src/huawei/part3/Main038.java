package huawei.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * @create: 2020-05-22 23:59
 **/
public class Main038 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                String s = bf.readLine();
                int count[] = new int[26];
                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }
                Arrays.sort(count);
                int k = 26;
                int sum = 0;
                for (int j = count.length - 1; j >= 0; j--) {
                    if (count[j] == 0) {
                        break;
                    }
                    sum += (k--) * count[j];
                }
                System.out.println(sum);
            }
        }

    }

}
