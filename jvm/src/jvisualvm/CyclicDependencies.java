package jvisualvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mirror
 * @date: 2020/4/28 19:45
 * @description: 参考链接 https://mp.weixin.qq.com/s/OCAbHjIdn_f-37WuAOv5Nw
 * 准备模拟内存泄漏样例
 * 1、定义静态变量HashMap
 * 2、分段循环创建对象，并加入HashMap
 * -Xms512m -Xmx512m -XX:-UseGCOverheadLimit -XX:MaxPermSize=50m
 */
public class CyclicDependencies {

    //声明缓存对象
    private static final Map map = new HashMap();

    public static void main(String[] args) {
        try {
            //给打开 jvisualvm 时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //循环添加对象到缓存
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("first");
        //为dump出堆提供时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("second");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("third");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 4000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("forth");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("qqqq");

    }

}
