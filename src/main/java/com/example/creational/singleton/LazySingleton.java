package com.example.creational.singleton;

/**
 * 双重检查锁（Double-Checked Locking）实现的懒汉式单例。
 *
 * <p>懒汉式在第一次调用 getInstance 时才创建实例，避免类加载阶段即创建对象的资源占用。
 * 为了保证多线程环境下只创建一个实例，采用 "双重检查锁" 模式：</p>
 * <ol>
 *   <li>第一次检查：若实例已存在，直接返回，避免不必要的同步开销；</li>
 *   <li>第二次检查：在同步块内再次判断，防止多个线程同时通过第一次检查后重复创建；</li>
 *   <li>使用 volatile 修饰实例字段，禁止指令重排序，避免其他线程拿到未初始化完成的对象。</li>
 * </ol>
 *
 * <p>适用场景：实例初始化较重、可能不会被使用、且对线程安全有要求时。</p>
 */
public class LazySingleton {

    /** 使用 volatile 禁止指令重排序，保证其他线程看到的实例已完全构造完成。 */
    private static volatile LazySingleton instance;

    /**
     * 私有构造方法，禁止外部 new。
     */
    private LazySingleton() {
        System.out.println("懒汉式 LazySingleton 实例被创建");
    }

    /**
     * 获取单例实例，使用双重检查锁保证线程安全与性能。
     *
     * @return 单例实例
     */
    public static LazySingleton getInstance() {
        // 第一次检查：避免每次都进入同步块，提升性能
        if (instance == null) {
            synchronized (LazySingleton.class) {
                // 第二次检查：防止多线程同时通过第一次检查后重复创建
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 业务方法，演示单例可对外提供的能力。
     *
     * @return 简单描述信息
     */
    public String describe() {
        return "我是懒汉式单例（双重检查锁），首次使用时才被创建";
    }
}
