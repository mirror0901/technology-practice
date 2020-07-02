package com.mirror.base.jvm.oom;

import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

/**
 * @author: mirror
 * @date: 2020/7/2 15:40
 * @description: Metaspace内存溢出
 * 1.问题描述
 * 元空间的溢出，系统会抛出java.lang.OutOfMemoryError: Metaspace。
 * 出现这个异常的问题的原因是系统的代码非常多或引用的第三方包非常多或者通过动态代码生成类加载等方法，
 * 导致元空间的内存占用很大。
 * 2.如何解决元空间的内存溢出呢？
 * 默认情况下，元空间的大小仅受本地内存限制。
 * 但是为了整机的性能，尽量还是要对该项进行设置，以免造成整机的服务停机。
 * 1)优化参数配置，避免影响其他JVM进程
 * 2)慎重引用第三方包
 * 3)关注动态生成类的框架
 */
public class MetaSpaceOomError {

    public static void main(String[] args) {
        ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
        //循环动态产生class
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaSpaceOomError.class);
            enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
            enhancer.setCallbackFilter(new CallbackFilter() {
                @Override
                public int accept(Method method) {
                    return 1;
                }

                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }

            });
            Class clazz = enhancer.createClass();
            System.out.println(clazz.getName());
            //显示数量信息(共加载过的类型数目,当前还有效的项目类型,已被卸载的类型数目)
            System.out.println("total:" + loadingBean.getTotalLoadedClassCount());
            System.out.println("active:" + loadingBean.getLoadedClassCount());
            System.out.println("unloaded:" + loadingBean.getUnloadedClassCount());
        }
    }

}
