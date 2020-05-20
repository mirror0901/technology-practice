package huawei;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: TODO
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * @create: 2020-05-16 21:47
 **/
public class Main022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String result = lengthCheck(str) && contentCheck(str) && subStrCheck(str) == true ? "OK" : "NG";
            System.out.println(result);
        }
        sc.close();
    }

    //验证是否满足条件一
    public static boolean lengthCheck(String str) {
        return str.length() > 8;
    }

    //验证是否满足条件二
    public static boolean contentCheck(String str) {
        String[] regex = {"[a-z]", "[A-Z]", "\\d", "[^a-zA-Z0-9]"};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            Pattern p = Pattern.compile(regex[i]);
            Matcher m = p.matcher(str);
            if (m.find()) {
                count++;
            }
        }
        return count >= 3 ? true : false;
    }

    //验证是否满足条件三
    public static boolean subStrCheck(String str) {
        return !str.matches(".*(...)(.*\\\\1).*");
    }

}