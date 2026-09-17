package com.example.behavioral.iterator;

/**
 * 聚合接口（Aggregate）。
 * 声明创建迭代器的方法，由具体聚合实现以返回与自身结构匹配的迭代器。
 */
public interface Aggregate {

    /**
     * 创建并返回该聚合的迭代器。
     *
     * @return 迭代器实例
     */
    Iterator createIterator();
}
