package com.example.behavioral.visitor;

/**
 * 具体元素 B。
 * 实现 accept 时调用 visitor.visit(this)，由 JVM 根据 this 的静态类型
 * 选择对应的重载方法，完成第二重分派。
 */
public class ConcreteElementB implements Element {

    /** 元素自身的数据 */
    private final int count;

    /**
     * 构造方法。
     *
     * @param count 数据值
     */
    public ConcreteElementB(int count) {
        this.count = count;
    }

    /**
     * 获取数据值。
     *
     * @return 数据值
     */
    public int getCount() {
        return count;
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
