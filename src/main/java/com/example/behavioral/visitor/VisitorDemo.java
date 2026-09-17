package com.example.behavioral.visitor;

/**
 * 访问者模式演示入口。
 * 演示同一对象结构在不同访问者下表现出不同的操作行为，
 * 通过双重分派在运行时选择对应方法。
 */
public class VisitorDemo {

    /**
     * 程序入口：演示访问者模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 访问者模式演示开始 =====");

        // 构造对象结构
        ObjectStructure structure = new ObjectStructure();
        structure.addElement(new ConcreteElementA("Hello, Visitor!"));
        structure.addElement(new ConcreteElementB(42));

        // 访问者 A 遍历结构（收集信息）
        System.out.println("--- 使用访问者 A（收集信息） ---");
        structure.accept(new ConcreteVisitorA());

        // 访问者 B 遍历结构（执行校验）
        System.out.println("--- 使用访问者 B（执行校验） ---");
        structure.accept(new ConcreteVisitorB());

        System.out.println("===== 访问者模式演示结束 =====");
    }
}
