package com.mirror.base.classload;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-15 01:34
 **/
public class NotInitialization {

    public static void main(String[] args) {

        /**
         * output:
         * superClass init!
         * 127
         *
         * 通过子类引用父类的静态对象不会导致子类的初始化
         * 只有直接定义这个字段的类才会被初始化
         */
        System.out.println(SuperClass.value);

        /**
         * output:
         *
         * 通过数组定义来引用类不会触发此类的初始化
         * 虚拟机在运行时动态创建了一个数组类
         */
        SuperClass[] sca = new SuperClass[10];

        /**
         * output: hello world!
         *
         * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义类常量的类
         * 因此不会触发定义常量的类的初始化
         * “hello world！”在编译期常量传播优化时已经存储到 NotInitialization 常量池中了
         */
        System.out.println(ConstClass.HELLOWORLD);

    }

}
