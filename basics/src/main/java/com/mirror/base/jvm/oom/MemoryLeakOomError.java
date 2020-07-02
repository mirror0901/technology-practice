package com.mirror.base.jvm.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mirror
 * @date: 2020/7/2 15:06
 * @description: 内存泄露导致的内存溢出
 * 设置 VM options 为: -Xms20m -Xmx20m
 * 1.问题描述
 * Java中的内存泄漏是一些对象不再被应用程序使用但垃圾收集无法识别的情况。
 * 因此，这些未使用的对象仍然在Java堆空间中无限期地存在。
 * 不停的堆积最终会触发java . lang.OutOfMemoryError。
 * 2.解决办法
 * 相对来说对应的解决方案比较简单：重写equals方法即可
 */
public class MemoryLeakOomError {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

//        @Override
//        public boolean equals(Object o) {
//            boolean response = false;
//            if (o instanceof Key) {
//                response = (((Key) o).id).equals(this.id);
//            }
//            return response;
//        }

    }

    public static void main(String[] args) {
        Map map = new HashMap();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!map.containsKey(new Key(i))) {
                    map.put(new Key(i), "Number:" + i);
                }
            }
        }
    }

}
