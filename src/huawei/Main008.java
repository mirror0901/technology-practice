package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * @create: 2020-05-16 21:47
 **/
public class Main008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            String[] split = s.split("\\s+");
            int index = Integer.valueOf(split[0]);
            int value = Integer.valueOf(split[1]);
            value = treeMap.getOrDefault(index, 0) + value;
            treeMap.put(index, value);
        }
        for (Map.Entry<Integer, Integer> item : treeMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

}