package huawei;


import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: TODO
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;
 * B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;
 * D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 * @create: 2020-05-16 21:47
 **/
public class Main020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int isA = 0;
        int isB = 0;
        int isC = 0;
        int isD = 0;
        int isE = 0;
        int isEroor = 0;
        int isPrivate = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] ips = str.split("~");

            //判断掩码是否合法
            boolean isMask = false;
            String[] maskArr = ips[1].split("\\.");
            String binaryMask = "";
            //形成掩码二进制字符串
            for (int i = 0; i < maskArr.length; i++) {
                String binaryStr = Integer.toBinaryString(Integer.parseInt(maskArr[i]));
                //凑成4组8位二进制
                for (int j = 0; j < 8 - binaryStr.length(); j++) {
                    binaryStr = "0" + binaryStr;
                }
                binaryMask += binaryStr;
            }
            //比较二进制字符串中第一个0的位置和最后一个1的位置来判断掩码是否合法
            if (binaryMask.indexOf("0") < binaryMask.lastIndexOf("1")) {
                isMask = false;
            } else {
                isMask = true;
            }

            //掩码合法后再来判断IP是否合法
            if (isMask) {
                String[] strArr = ips[0].split("\\.");
                if (strArr.length == 4) {
                    int[] ipArr = new int[4];
                    for (int i = 0; i < 4; i++) {
                        if (strArr[i] == "") {
                            ipArr[i] = -1;
                        } else {
                            ipArr[i] = Integer.parseInt(strArr[i]);
                        }
                    }
                    if ((0 <= ipArr[0] && ipArr[0] <= 255) && (0 <= ipArr[1] && ipArr[1] <= 255) && (0 <= ipArr[2] && ipArr[2] <= 255) && (0 <= ipArr[3] && ipArr[3] <= 255)) {
                        if (ipArr[0] >= 1 && ipArr[0] <= 126) {
                            isA++;
                            if (ipArr[0] == 10)
                                isPrivate++;
                        } else if (ipArr[0] >= 128 && ipArr[0] <= 191) {
                            isB++;
                            if (ipArr[0] == 172 && (ipArr[1] >= 16 && ipArr[1] <= 31))
                                isPrivate++;
                        } else if (ipArr[0] >= 192 && ipArr[0] <= 223) {
                            isC++;
                            if (ipArr[0] == 192 && ipArr[1] == 168)
                                isPrivate++;
                        } else if (ipArr[0] >= 224 && ipArr[0] <= 239) {
                            isD++;
                        } else if (ipArr[0] >= 240 && ipArr[0] <= 255) {
                            isE++;
                        }
                    } else {
                        isEroor++;
                    }
                } else {
                    isEroor++;
                }

            } else {
                isEroor++;
            }
        }
        System.out.println(isA + " " + isB + " " + isC + " " + isD + " " + isE + " " + isEroor + " " + isPrivate);
        sc.close();
    }
}