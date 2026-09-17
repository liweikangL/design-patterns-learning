package com.example.structural.proxy;

/**
 * 静态代理（StaticProxy）。
 * <p>
 * 在编译期就确定代理类：实现 {@link Subject}，持有 {@link RealSubject}，
 * 在调用前后织入前置/后置逻辑。优点是简单直观，缺点是一个代理类只能代理一种接口。
 */
public class StaticProxy implements Subject {

    /** 被代理的真实主题 */
    private final RealSubject realSubject;

    /**
     * 构造静态代理，注入被代理对象。
     *
     * @param realSubject 被代理的真实主题
     */
    public StaticProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        // 前置增强：权限校验 / 日志
        System.out.println("[静态代理] 前置：记录调用日志、检查权限");
        realSubject.request();
        // 后置增强：清理 / 统计
        System.out.println("[静态代理] 后置：记录耗时、清理资源");
    }
}
