package huawei.part4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 * （一组测试用例里可能有多组数据，请注意处理）
 * @create: 2020-05-23 11:55
 **/
public class Main046 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int count = 0;
            for (int i = 7; i <= N; i++) {
                if (i % 7 == 0)
                    count++;
                else if (hasSeven(i))
                    count++;
            }
            System.out.println(count);
        }
    }

    static boolean hasSeven(int i) {
        if (i % 10 == 7)
            return true;
        else if (i / 10 >= 7)
            return hasSeven(i / 10);
        else return false;
    }

}

