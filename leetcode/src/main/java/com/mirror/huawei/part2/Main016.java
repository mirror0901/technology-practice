package com.mirror.huawei.part2;


import java.util.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入第一行为一个正整数n(1 ≤ n ≤ 1000), 下面n行为n个字符串(字符串长度 ≤ 100), 字符串中只含有大小写字母。
 * @create: 2020-05-16 21:47
 **/
public class Main016 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer len = Integer.valueOf(sc.nextLine());
//        TreeSet<String> treeSet = new TreeSet();
        List<String> treeSet = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            final String s = sc.nextLine();
            treeSet.add(s);
        }
        Collections.sort(treeSet);
        for (String item : treeSet) {
            System.out.println(item);
        }
//        final Iterator<String> iterator = treeSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        sc.close();
    }
}