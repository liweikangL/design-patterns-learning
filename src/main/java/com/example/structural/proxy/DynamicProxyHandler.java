package com.example.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理处理器（DynamicProxyHandler）。
 * <p>
 * 实现 {@link InvocationHandler}，在运行时为任意接口生成代理对象。
 * 一个处理器可代理任意实现了接口的目标对象，无需为每个接口写代理类。
 */
public class DynamicProxyHandler implements InvocationHandler {

    /** 被代理的目标对象 */
    private final Object target;

    /**
     * 构造动态代理处理器，注入被代理目标。
     *
     * @param target 被代理对象（必须实现至少一个接口）
     */
    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强
        System.out.println("[动态代理] 前置：调用 " + method.getName() + "，参数=" + args);
        long start = System.currentTimeMillis();
        try {
            // 真实调用
            Object result = method.invoke(target, args);
            return result;
        } finally {
            // 后置增强
            long cost = System.currentTimeMillis() - start;
            System.out.println("[动态代理] 后置：" + method.getName() + " 耗时 " + cost + " ms");
        }
    }
}
