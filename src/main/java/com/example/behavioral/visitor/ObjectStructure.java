package com.example.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构（ObjectStructure）。
 * 维护元素集合，并允许访问者遍历所有元素。
 */
public class ObjectStructure {

    /** 元素集合 */
    private final List<Element> elements = new ArrayList<>();

    /**
     * 添加元素。
     *
     * @param element 元素
     */
    public void addElement(Element element) {
        elements.add(element);
    }

    /**
     * 接受一个访问者，让其遍历并访问所有元素。
     *
     * @param visitor 访问者
     */
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
