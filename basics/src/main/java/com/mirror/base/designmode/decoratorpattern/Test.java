package com.mirror.base.designmode.decoratorpattern;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-23 23:32
 **/
public class Test {

    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }

}
