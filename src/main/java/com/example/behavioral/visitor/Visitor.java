package com.example.behavioral.visitor;

/**
 * 抽象访问者（Visitor）。
 * 为每一种具体元素声明对应的 visit 重载方法。
 */
public interface Visitor {

    /**
     * 访问具体元素 A。
     *
     * @param elementA 具体元素 A
     */
    void visit(ConcreteElementA elementA);

    /**
     * 访问具体元素 B。
     *
     * @param elementB 具体元素 B
     */
    void visit(ConcreteElementB elementB);
}
