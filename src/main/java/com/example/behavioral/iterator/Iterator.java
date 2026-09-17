package com.example.behavioral.iterator;

/**
 * 迭代器接口（Iterator）。
 * 声明判断是否有下一个元素以及获取下一个元素的方法。
 */
public interface Iterator {

    /**
     * 判断是否还有下一个元素。
     *
     * @return true 表示仍有元素可迭代
     */
    boolean hasNext();

    /**
     * 返回下一个元素。
     *
     * @return 下一个元素
     */
    Object next();
}
