package com.example.behavioral.iterator;

/**
 * 迭代器模式演示入口。
 * 演示如何通过迭代器遍历聚合对象而不暴露其内部数组。
 */
public class IteratorDemo {

    /**
     * 程序入口：演示迭代器模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 迭代器模式演示开始 =====");

        String[] names = {"张三", "李四", "王五", "赵六"};
        Aggregate repository = new NameRepository(names);

        Iterator iterator = repository.createIterator();
        System.out.println("开始遍历名字仓库：");
        while (iterator.hasNext()) {
            Object name = iterator.next();
            System.out.println("  访问到：" + name);
        }
        System.out.println("遍历结束。");

        System.out.println("===== 迭代器模式演示结束 =====");
    }
}
