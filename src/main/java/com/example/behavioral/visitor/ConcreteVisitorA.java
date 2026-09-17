package com.example.behavioral.visitor;

/**
 * 具体访问者 A：收集元素信息。
 */
public class ConcreteVisitorA implements Visitor {

    /**
     * 访问元素 A，提取字符串数据。
     *
     * @param elementA 具体元素 A
     */
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("访问者 A -> 元素 A，字符串数据 = " + elementA.getValue());
    }

    /**
     * 访问元素 B，提取数值数据。
     *
     * @param elementB 具体元素 B
     */
    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("访问者 A -> 元素 B，数值数据 = " + elementB.getCount());
    }
}
