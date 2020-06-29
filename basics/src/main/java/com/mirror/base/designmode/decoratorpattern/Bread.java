package com.mirror.base.designmode.decoratorpattern;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-23 23:26
 **/
public class Bread extends Food {

    private Food basicFood;

    public Bread(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + "+面包";
    }

}
