package com.example.creational.singleton;

/**
 * 静态内部类实现的懒加载单例。
 *
 * <p>利用 JVM 类加载机制保证线程安全，同时实现懒加载：</p>
 * <ul>
 *   <li>外部类加载时不会立即加载内部类 Holder，只有在调用 getInstance 时才会触发 Holder 的加载；</li>
 *   <li>JVM 在类初始化阶段会加锁，保证 Holder.INSTANCE 只被创建一次；</li>
 *   <li>无需显式 synchronized，性能优于双重检查锁。</li>
 * </ul>
 *
 * <p>适用场景：既希望懒加载、又希望利用 JVM 机制保证线程安全时，这是推荐写法。</p>
 */
public class StaticInnerClassSingleton {

    /**
     * 私有构造方法，禁止外部 new。
     */
    private StaticInnerClassSingleton() {
        System.out.println("静态内部类 StaticInnerClassSingleton 实例被创建");
    }

    /**
     * 获取单例实例。
     *
     * @return 单例实例
     */
    public static StaticInnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 业务方法，演示单例可对外提供的能力。
     *
     * @return 简单描述信息
     */
    public String describe() {
        return "我是静态内部类单例，结合懒加载与线程安全";
    }

    /**
     * 静态内部类持有外部类的唯一实例。
     * 类加载是线程安全的，且只有被引用时才会加载，实现懒加载。
     */
    private static class Holder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
}
