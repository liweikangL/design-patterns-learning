package com.example.behavioral.visitor;

/**
 * 具体访问者 B：对元素进行校验。
 */
public class ConcreteVisitorB implements Visitor {

    /**
     * 访问元素 A，校验字符串是否非空。
     *
     * @param elementA 具体元素 A
     */
    @Override
    public void visit(ConcreteElementA elementA) {
        boolean valid = elementA.getValue() != null && !elementA.getValue().isEmpty();
        System.out.println("访问者 B -> 校验元素 A，是否非空 = " + valid);
    }

    /**
     * 访问元素 B，校验数值是否为正数。
     *
     * @param elementB 具体元素 B
     */
    @Override
    public void visit(ConcreteElementB elementB) {
        boolean positive = elementB.getCount() > 0;
        System.out.println("访问者 B -> 校验元素 B，是否为正数 = " + positive);
    }
}
