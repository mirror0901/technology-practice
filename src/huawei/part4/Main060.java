package huawei.part4;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: TODO
 * 参数解析
 * @create: 2020-05-23 16:58
 **/
public class Main060 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"') {
                quotaNum++;
                continue;
            }
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else if (quotaNum % 2 == 0) {
                sb.append('\n');
                len++;
            } else {
                sb.append(' ');
            }
        }
        System.out.println(len + 1);
        System.out.println(sb.toString());

    }

}
