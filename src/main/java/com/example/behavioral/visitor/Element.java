package com.example.behavioral.visitor;

/**
 * 抽象元素（Element）。
 * 声明 accept 方法，由具体元素实现以触发双重分派。
 */
public interface Element {

    /**
     * 接受一个访问者，由具体元素在内部回调访问者的 visit 方法。
     *
     * @param visitor 访问者
     */
    void accept(Visitor visitor);
}
