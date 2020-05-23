package huawei.part3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-22 00:43
 **/
public class Main035 {

    static HashMap<Integer, String> dict = new HashMap<>();

    static {
        dict.put(0, "zero");
        dict.put(1, "one");
        dict.put(2, "two");
        dict.put(3, "three");
        dict.put(4, "four");
        dict.put(5, "five");
        dict.put(6, "six");
        dict.put(7, "seven");
        dict.put(8, "eight");
        dict.put(9, "nine");
        dict.put(10, "ten");
        dict.put(11, "eleven");
        dict.put(12, "twelve");
        dict.put(13, "thirteen");
        dict.put(14, "fourteen");
        dict.put(15, "fifteen");
        dict.put(16, "sixteen");
        dict.put(17, "seventeen");
        dict.put(18, "eighteen");
        dict.put(19, "nineteen");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String str = scanner.nextLine();
            if (str.length() > 0 && str.length() <= 9 && !str.contains(".")) {
                int num = Integer.valueOf(str);
                System.out.println(parse(num));
            }
        }
        scanner.close();
    }

    /**
     * 翻译为英文
     *
     * @param num
     * @return
     */
    public static String parse(int num) {
        final int len = String.valueOf(num).length();
        if (len == 1) {
            return dict.get(num);
        } else if (len == 2) {
            if (num <= 19) {
                return dict.get(num);
            } else if (num < 30) {
                return num % 10 != 0 ? "twenty " + dict.get(num % 10) : "twenty";
            } else if (num < 40) {
                return num % 10 != 0 ? "thirty " + dict.get(num % 10) : "thirty";
            } else if (num < 50) {
                return num % 10 != 0 ? "forty " + dict.get(num % 10) : "forty";
            } else if (num < 60) {
                return num % 10 != 0 ? "fifty " + dict.get(num % 10) : "fifty";
            } else if (num < 70) {
                return num % 10 != 0 ? "sixty " + dict.get(num % 10) : "sixty";
            } else if (num < 80) {
                return num % 10 != 0 ? "seventy " + dict.get(num % 10) : "seventy";
            } else if (num < 90) {
                return num % 10 != 0 ? "eighty " + dict.get(num % 10) : "eighty";
            } else if (num < 100) {
                return num % 10 != 0 ? "ninety " + dict.get(num % 10) : "ninety";
            }

        } else if (len == 3) {//hundred
            String str = parse(num / 100) + " hundred ";
            num -= num / 100 * 100;
            if (num != 0) {
                str += "and " + parse(num);
            }
            return str.trim();
        } else if (len == 4 || len == 5 || len == 6) {//thousand
            String str = parse(num / 1000) + " thousand ";
            num -= num / 1000 * 1000;
            if (num != 0) {
                //if (num < 100) str += "and ";
                str += parse(num);
            }
            return str.trim();
        } else if (len == 7 || len == 8 || len == 9) {//million hundred thousand
            String str = parse(num / 1000000) + " million ";
            num -= num / 1000000 * 1000000;
            if (num != 0) {
                if (num < 100000) str += "and ";
                str += parse(num);
            }
            return str.trim();
        }

        return "error";
    }

}
