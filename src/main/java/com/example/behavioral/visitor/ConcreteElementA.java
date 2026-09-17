package com.example.behavioral.visitor;

/**
 * 具体元素 A。
 * 实现 accept 时调用 visitor.visit(this)，由 JVM 根据 this 的静态类型
 * 选择对应的重载方法，完成第二重分派。
 */
public class ConcreteElementA implements Element {

    /** 元素自身的数据 */
    private final String value;

    /**
     * 构造方法。
     *
     * @param value 数据值
     */
    public ConcreteElementA(String value) {
        this.value = value;
    }

    /**
     * 获取数据值。
     *
     * @return 数据值
     */
    public String getValue() {
        return value;
    }

    /**
     * 接受访问者：触发双重分派，调用对应重载的 visit 方法。
     *
     * @param visitor 访问者
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
