package com.example.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体原型 A：使用继承自 {@link Prototype} 的默认浅拷贝。
 *
 * <p>包含一个引用类型字段 {@code tags}，演示浅拷贝下
 * 克隆对象与原对象共享该字段引用，修改会相互影响。</p>
 */
public class ConcretePrototypeA extends Prototype {

    /** 可变引用字段，用于演示浅拷贝的"共享引用"行为。 */
    private List<String> tags = new ArrayList<>();

    /**
     * 构造原型 A，指定名称。
     *
     * @param name 原型名称
     */
    public ConcretePrototypeA(String name) {
        super(name);
    }

    /**
     * 返回标签列表。
     *
     * @return 标签列表
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 添加标签。
     *
     * @param tag 标签内容
     */
    public void addTag(String tag) {
        tags.add(tag);
    }

    /**
     * 描述当前原型状态。
     *
     * @return 包含名称与标签的描述字符串
     */
    @Override
    public String describe() {
        return "ConcretePrototypeA{name='" + getName() + "', tags=" + tags + "}";
    }
}
