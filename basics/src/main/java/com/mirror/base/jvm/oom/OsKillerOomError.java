package com.mirror.base.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror
 * @date: 2020/7/2 16:34
 * @description: 系统杀死进程内存溢出
 * 1.问题概述
 * 在描述该问题之前，先熟悉一点操作系统的知识：操作系统是建立在进程的概念之上，这些进程在内核中作业，
 * 其中有一个非常特殊的进程，称为“内存杀手（Out of memory killer）”。
 * 当内核检测到系统内存不足时，OOM killer被激活，检查当前谁占用内存最多然后将该进程杀掉。
 * 一般Out of memory:Kill process or sacrifice child错会在当可用虚拟虚拟内存(包括交换空间)消耗到让整个操作系统面临风险时，会被触发。
 * 在这种情况下，OOM Killer会选择“流氓进程”并杀死它。
 * 2.解决方法
 * 虽然增加交换空间的方式可以缓解Java heap space异常，还是建议最好的方案就是升级系统内存，让java应用有足够的内存可用，就不会出现这种问题。
 */
public class OsKillerOomError {

    public static void main(String[] args) {
        List<int[]> l = new ArrayList<>();
        for (int i = 10000; i < 100000; i++) {
            try {
                l.add(new int[100000000]);
                System.out.println(i);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
