package com.example.behavioral.template;

/**
 * 模板方法模式演示入口。
 * 演示同一骨架下不同子类的实现差异以及钩子方法对流程的影响。
 */
public class TemplateDemo {

    /**
     * 程序入口：演示模板方法模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 模板方法模式演示开始 =====");

        AbstractClass classA = new ConcreteClassA();
        AbstractClass classB = new ConcreteClassB();

        System.out.println("--- 使用具体类 A（钩子为 true，会执行额外步骤） ---");
        classA.templateMethod();

        System.out.println();
        System.out.println("--- 使用具体类 B（钩子为 false，跳过额外步骤） ---");
        classB.templateMethod();

        System.out.println("===== 模板方法模式演示结束 =====");
    }
}
