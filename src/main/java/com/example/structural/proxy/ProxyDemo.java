package com.example.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式演示入口。
 * <p>
 * 同时演示静态代理与 JDK 动态代理两种实现。
 */
public class ProxyDemo {

    /**
     * 程序入口，演示代理模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 代理模式演示 =====");

        RealSubject real = new RealSubject();

        // 1. 静态代理
        System.out.println("\n【1】静态代理：");
        Subject staticProxy = new StaticProxy(real);
        staticProxy.request();

        // 2. JDK 动态代理
        System.out.println("\n【2】JDK 动态代理：");
        Subject dynamicProxy = (Subject) Proxy.newProxyInstance(
                real.getClass().getClassLoader(),
                real.getClass().getInterfaces(),
                new DynamicProxyHandler(real)
        );
        dynamicProxy.request();

        System.out.println("\n静态代理需为每个接口单独编写代理类；动态代理一个 InvocationHandler "
                + "可代理任意接口实现，是 Spring AOP 的底层基础。");
    }
}
