package com.example.creational.singleton;

/**
 * 单例模式演示入口。
 *
 * <p>本 Demo 同时演示三种单例实现，并对比它们的特性：</p>
 * <ul>
 *   <li>饿汉式 {@link Singleton}：类加载即创建实例；</li>
 *   <li>懒汉式双重检查锁 {@link LazySingleton}：首次使用时创建，多线程安全；</li>
 *   <li>静态内部类 {@link StaticInnerClassSingleton}：懒加载 + 线程安全，推荐写法。</li>
 * </ul>
 */
public class SingletonDemo {

    /**
     * 程序入口，演示三种单例实现的获取与使用。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("====== 单例模式演示开始 ======");

        // 1. 饿汉式：调用时实例早已创建
        System.out.println("\n[1] 获取饿汉式单例实例：");
        Singleton hungry1 = Singleton.getInstance();
        Singleton hungry2 = Singleton.getInstance();
        System.out.println("饿汉式两次获取是否同一实例：" + (hungry1 == hungry2));
        System.out.println(hungry1.describe());

        // 2. 懒汉式：首次调用时才会创建实例
        System.out.println("\n[2] 获取懒汉式（双重检查锁）单例实例：");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("懒汉式两次获取是否同一实例：" + (lazy1 == lazy2));
        System.out.println(lazy1.describe());

        // 3. 静态内部类：首次调用时触发内部类加载
        System.out.println("\n[3] 获取静态内部类单例实例：");
        StaticInnerClassSingleton inner1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton inner2 = StaticInnerClassSingleton.getInstance();
        System.out.println("静态内部类两次获取是否同一实例：" + (inner1 == inner2));
        System.out.println(inner1.describe());

        System.out.println("\n三种实现均保证全局唯一实例，差异在于初始化时机与线程安全策略。");
        System.out.println("====== 单例模式演示结束 ======");
    }
}
