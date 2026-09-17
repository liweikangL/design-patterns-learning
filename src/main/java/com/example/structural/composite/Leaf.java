package com.example.structural.composite;

/**
 * 叶子节点（Leaf）。
 * <p>
 * 表示文件系统中的"文件"，没有子节点。
 * 业务方法直接展示文件名，管理子节点的方法沿用父类默认实现（抛出异常）。
 */
public class Leaf extends Component {

    /**
     * 构造文件叶子节点。
     *
     * @param name 文件名
     */
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation(String prefix) {
        System.out.println(prefix + "📄 " + name);
    }
}
