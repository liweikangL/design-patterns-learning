package com.example.creational.prototype;

/**
 * 原型模式抽象基类，实现 {@link Cloneable} 标记接口。
 *
 * <p>声明 {@link #clone()} 方法供具体原型继承或重写，提供默认的浅拷贝实现。
 * 子类既可直接复用浅拷贝，也可重写为深拷贝，以适配自身可变字段的复制需求。</p>
 */
public abstract class Prototype implements Cloneable {

    /** 原型名称，演示基本字段的拷贝。 */
    private String name;

    /**
     * 构造原型，指定名称。
     *
     * @param name 原型名称
     */
    public Prototype(String name) {
        this.name = name;
    }

    /**
     * 返回原型名称。
     *
     * @return 原型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置原型名称。
     *
     * @param name 原型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 浅拷贝：调用 {@code super.clone()} 复制所有字段。
     *
     * <p>对于基本类型字段会独立复制；对于引用类型字段，
     * 克隆对象与原对象将共享同一引用，修改会相互影响。</p>
     *
     * @return 当前原型的拷贝
     */
    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            // 本类实现了 Cloneable，理论上不会进入此分支
            throw new AssertionError("原型不支持克隆", e);
        }
    }

    /**
     * 业务方法，由具体原型实现，用于展示原型对外行为。
     *
     * @return 描述当前原型状态的字符串
     */
    public abstract String describe();
}
