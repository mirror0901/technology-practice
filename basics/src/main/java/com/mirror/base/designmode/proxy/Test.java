package com.mirror.base.designmode.proxy;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-24 00:30
 **/
public class Test {

    public static void main(String[] args) {
        ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
        proxyInterface.marry();
    }

}
