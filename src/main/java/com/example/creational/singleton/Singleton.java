package com.example.creational.singleton;

/**
 * 饿汉式单例模式实现。
 *
 * <p>饿汉式在类加载阶段就完成实例的创建，因此天然是线程安全的。
 * 其优点是实现简单、无需加锁；缺点是无论是否使用都会创建实例，
 * 可能造成资源浪费，也无法在运行时动态注入参数。</p>
 *
 * <p>适用场景：实例较轻量、初始化不耗时、且一定会被使用时。</p>
 */
public class Singleton {

    /** 类加载时即创建唯一实例，使用 final 保证引用不可变。 */
    private static final Singleton INSTANCE = new Singleton();

    /**
     * 私有构造方法，禁止外部通过 new 创建实例。
     */
    private Singleton() {
        System.out.println("饿汉式 Singleton 实例被创建");
    }

    /**
     * 获取单例实例的唯一入口。
     *
     * @return 单例实例
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }

    /**
     * 业务方法，演示单例可对外提供的能力。
     *
     * @return 简单描述信息
     */
    public String describe() {
        return "我是饿汉式单例，类加载时即被创建";
    }
}
