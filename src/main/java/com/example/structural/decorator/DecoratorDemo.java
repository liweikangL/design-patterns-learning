package com.example.structural.decorator;

/**
 * 装饰器模式演示入口。
 * <p>
 * 演示通过多层装饰器叠加功能，且可任意调整装饰顺序。
 */
public class DecoratorDemo {

    /**
     * 程序入口，演示装饰器模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 装饰器模式演示 =====");

        // 1. 仅使用基础构件
        Component base = new ConcreteComponent();
        System.out.println("\n【1】基础构件：");
        System.out.println("  结果 = " + base.operation());

        // 2. 单层装饰：用 A（添加状态）
        Component withA = new ConcreteDecoratorA(base, "加奶(状态A)");
        System.out.println("\n【2】装饰一层 A：");
        System.out.println("  结果 = " + withA.operation());

        // 3. 双层装饰：A 基础上再叠 B（添加行为）
        Component withAB = new ConcreteDecoratorB(withA);
        System.out.println("\n【3】先 A 后 B 装饰：");
        System.out.println("  结果 = " + withAB.operation());

        // 4. 改变装饰顺序：先 B 后 A
        Component withBA = new ConcreteDecoratorA(new ConcreteDecoratorB(base), "加奶(状态A)");
        System.out.println("\n【4】先 B 后 A 装饰：");
        System.out.println("  结果 = " + withBA.operation());

        System.out.println("\n装饰器在保持接口不变的情况下叠加职责，且可以多层、任意顺序组合。");
    }
}
