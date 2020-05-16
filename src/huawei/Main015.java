package huawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * @create: 2020-05-16 21:47
 **/
public class Main015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        final String[] split = str.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            final String s = split[i];
//            for (int j = s.length() - 1; j >= 0; j--) {
//                stringBuilder = stringBuilder.append(s.charAt(j));
//            }
            stringBuilder.append(s);
            stringBuilder.append(' ');
        }
        System.out.println(stringBuilder);
        sc.close();
    }
}