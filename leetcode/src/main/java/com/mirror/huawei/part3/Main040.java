package com.mirror.huawei.part3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * @create: 2020-05-23 09:29
 **/
public class Main040 {
    /***********如果需要频繁地从列表的中间位置添加和移除元素，且只要顺序地访问列表元素时，LinkedList实现更好************/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int firstNode = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(firstNode);
            for (int i = 0; i < num - 1; i++) {
                //要插入的节点
                int Node1 = sc.nextInt();
                //插入在哪个节点之后
                int Node2 = sc.nextInt();
                int index = list.indexOf(Node2);
                list.add(index + 1, Node1);
            }
            final int deleteNode = sc.nextInt();
            list.remove(deleteNode);
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.println(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1) + " ");
        }
        sc.close();
    }


}
