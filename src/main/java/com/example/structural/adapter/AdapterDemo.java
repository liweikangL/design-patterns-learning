package com.example.structural.adapter;

/**
 * 适配器模式演示入口。
 * <p>
 * 同时演示对象适配器与类适配器两种实现方式。
 */
public class AdapterDemo {

    /**
     * 程序入口，演示适配器模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 适配器模式演示 =====");

        // 1. 对象适配器：通过组合方式适配
        System.out.println("\n【1】对象适配器演示（推荐方式）：");
        Adaptee adaptee = new Adaptee();
        Target objectAdapter = new ObjectAdapter(adaptee);
        objectAdapter.request();

        // 2. 类适配器：通过继承方式适配
        System.out.println("\n【2】类适配器演示：");
        Target classAdapter = new ClassAdapter();
        classAdapter.request();

        System.out.println("\n两种适配器都把 Adaptee 的接口转换成了 Target，客户端只感知 Target。");
    }
}
