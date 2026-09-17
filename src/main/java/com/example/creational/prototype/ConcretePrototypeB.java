package com.example.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体原型 B：重写 {@link #clone()} 实现深拷贝。
 *
 * <p>在浅拷贝基础上额外复制引用类型字段 {@code tags}，
 * 使克隆对象与原对象互不影响，演示深拷贝的正确做法。</p>
 */
public class ConcretePrototypeB extends Prototype {

    /** 可变引用字段，演示深拷贝时需独立复制。 */
    private List<String> tags = new ArrayList<>();

    /**
     * 构造原型 B，指定名称。
     *
     * @param name 原型名称
     */
    public ConcretePrototypeB(String name) {
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
     * 深拷贝：先通过 {@code super.clone()} 完成基本字段复制，
     * 再手动复制引用类型字段 {@code tags}，确保克隆对象独立。
     *
     * @return 与原对象互不影响的拷贝
     */
    @Override
    public Prototype clone() {
        // 先完成浅拷贝（基本字段 + 引用字段地址）
        ConcretePrototypeB cloned = (ConcretePrototypeB) super.clone();
        // 再对引用类型字段做独立复制，实现深拷贝
        cloned.tags = new ArrayList<>(this.tags);
        return cloned;
    }

    /**
     * 描述当前原型状态。
     *
     * @return 包含名称与标签的描述字符串
     */
    @Override
    public String describe() {
        return "ConcretePrototypeB{name='" + getName() + "', tags=" + tags + "}";
    }
}
