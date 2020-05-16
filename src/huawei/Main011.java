package huawei;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。注意是不同的字符
 * @create: 2020-05-16 21:47
 **/
public class Main011 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = s.length(); i > 0; i--) {
            set.add(s.substring(i - 1, i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        final Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            stringBuilder = stringBuilder.append(iterator.next());
        }
        System.out.println(stringBuilder);
        scanner.close();
    }

}