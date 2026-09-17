package com.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器节点（Composite）。
 * <p>
 * 表示文件系统中的"目录"，可包含若干子构件（文件或子目录）。
 * 实现 add/remove/getChildren，并在 operation() 中递归调用子节点。
 */
public class Composite extends Component {

    /** 子节点集合 */
    private final List<Component> children = new ArrayList<>();

    /**
     * 构造目录容器节点。
     *
     * @param name 目录名
     */
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void operation(String prefix) {
        System.out.println(prefix + "📁 " + name + "/");
        // 递归处理每个子节点，层级缩进加深一级
        String childPrefix = prefix + "    ";
        for (Component child : children) {
            child.operation(childPrefix);
        }
    }
}
