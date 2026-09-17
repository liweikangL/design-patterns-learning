package com.example.structural.composite;

/**
 * 组合模式演示入口。
 * <p>
 * 以文件系统目录树为例，演示树形结构的构建与递归展示。
 */
public class CompositeDemo {

    /**
     * 程序入口，演示组合模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 组合模式演示（文件系统目录树） =====");

        // 构建根目录
        Composite root = new Composite("root");

        // 根目录下放两个文件和一个子目录
        root.add(new Leaf("readme.txt"));
        root.add(new Leaf("pom.xml"));

        Composite src = new Composite("src");
        src.add(new Leaf("Main.java"));
        src.add(new Leaf("Utils.java"));

        // src 下再嵌套一个子目录 resources
        Composite resources = new Composite("resources");
        resources.add(new Leaf("app.properties"));
        resources.add(new Leaf("logo.png"));
        src.add(resources);

        root.add(src);

        // 再加一个 docs 目录
        Composite docs = new Composite("docs");
        docs.add(new Leaf("adapter.md"));
        docs.add(new Leaf("bridge.md"));
        root.add(docs);

        // 统一调用 operation()，递归打印整棵树
        System.out.println("\n【1】递归展示目录树：");
        root.operation("");

        // 单独打印子树
        System.out.println("\n【2】单独展示 src 子树（客户端对叶子/容器一视同仁）：");
        src.operation("");

        System.out.println("\n叶子与容器实现同一接口，客户端可递归、统一处理整棵树。");
    }
}
