package com.mirror.base.designmode.decoratorpattern;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-23 23:26
 **/
public class Cream extends Food {

    private Food basicFood;

    public Cream(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + "+奶油";
    }

}
