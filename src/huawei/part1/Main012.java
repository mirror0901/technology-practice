package huawei.part1;


import java.util.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。注意是不同的字符
 * @create: 2020-05-16 21:47
 **/
public class Main012 {

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        System.out.println(set.size());
    }

}