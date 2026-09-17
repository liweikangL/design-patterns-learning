package com.example.behavioral.iterator;

/**
 * 具体聚合：名字仓库。
 * 内部以数组形式存储一组名字，并返回对应的 {@link NameIterator}。
 */
public class NameRepository implements Aggregate {

    /** 内部存储的名字数组 */
    private final String[] names;

    /**
     * 构造方法，初始化名字数组。
     *
     * @param names 名字数组
     */
    public NameRepository(String[] names) {
        this.names = names;
    }

    /**
     * 创建并返回该仓库的迭代器。
     *
     * @return 名字迭代器
     */
    @Override
    public Iterator createIterator() {
        return new NameIterator(names);
    }
}
