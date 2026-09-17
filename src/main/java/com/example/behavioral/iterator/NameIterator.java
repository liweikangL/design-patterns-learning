package com.example.behavioral.iterator;

/**
 * 具体迭代器：名字迭代器。
 * 按数组顺序遍历元素，跟踪当前下标，不暴露聚合内部数组结构。
 */
public class NameIterator implements Iterator {

    /** 被遍历的数组 */
    private final String[] names;

    /** 当前下标 */
    private int index = 0;

    /**
     * 构造方法。
     *
     * @param names 被遍历的名字数组
     */
    public NameIterator(String[] names) {
        this.names = names;
    }

    /**
     * 判断是否仍有下一个元素。
     *
     * @return true 表示还有元素
     */
    @Override
    public boolean hasNext() {
        return index < names.length;
    }

    /**
     * 返回下一个元素并前移游标。
     *
     * @return 下一个名字
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return names[index++];
        }
        return null;
    }
}
