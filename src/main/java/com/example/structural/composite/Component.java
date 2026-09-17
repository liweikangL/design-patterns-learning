package com.example.structural.composite;

import java.util.List;

/**
 * 抽象构件（Component）。
 * <p>
 * 叶子和容器共有的统一接口，定义业务方法 {@link #operation()} 与
 * 子节点管理方法。透明式组合模式将管理方法上移到构件层，使客户端
 * 可以一致地对待叶子和容器。
 */
public abstract class Component {

    /** 节点名称 */
    protected final String name;

    /**
     * 构造构件，传入名称。
     *
     * @param name 节点名称
     */
    public Component(String name) {
        this.name = name;
    }

    /**
     * 业务方法：展示节点信息。
     *
     * @param prefix 用于缩进展示层级的缩进前缀
     */
    public abstract void operation(String prefix);

    /**
     * 添加子节点。叶子节点默认不支持，抛出异常。
     *
     * @param component 子构件
     */
    public void add(Component component) {
        throw new UnsupportedOperationException("叶子节点 " + name + " 不支持添加子节点");
    }

    /**
     * 移除子节点。叶子节点默认不支持，抛出异常。
     *
     * @param component 子构件
     */
    public void remove(Component component) {
        throw new UnsupportedOperationException("叶子节点 " + name + " 不支持移除子节点");
    }

    /**
     * 获取直接子节点。叶子节点默认返回空列表。
     *
     * @return 子节点列表
     */
    public List<Component> getChildren() {
        throw new UnsupportedOperationException("叶子节点 " + name + " 没有子节点");
    }
}
