package com.mirror.base.jvm.oom;

/**
 * @author: mirror
 * @date: 2020/7/2 16:11
 * @description:栈溢出 1.问题描述
 * 当一个线程执行一个Java方法时，JVM将创建一个新的栈帧并且把它push到栈顶。
 * 此时新的栈帧就变成了当前栈帧，方法执行时，使用栈帧来存储参数、局部变量、中间指令以及其他数据。
 * 当一个方法递归调用自己时，新的方法所产生的数据(也可以理解为新的栈帧)将会被push到栈顶，方法每次调用自己时，
 * 会拷贝一份当前方法的数据并push到栈中。因此，递归的每层调用都需要创建一个新的栈帧。
 * 这样的结果是，栈中越来越多的内存将随着递归调用而被消耗，如果递归调用自己一百万次，那么将会产生一百万个栈帧。
 * 这样就会造成栈的内存溢出。
 * 2.解决办法
 * 如果程序中确实有递归调用，出现栈溢出时，可以调高-Xss大小，就可以解决栈内存溢出的问题了。
 * 递归调用防止形成死循环，否则就会出现栈内存溢出。
 */
public class StackOomError {

    int num = 1;

    public void testStack() {
        num++;
        this.testStack();
    }

    public static void main(String[] args) {
        StackOomError t = new StackOomError();
        t.testStack();
    }

}
