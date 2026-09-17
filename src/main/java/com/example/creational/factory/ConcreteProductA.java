package com.example.creational.factory;

/**
 * 具体产品 A。
 *
 * <p>实现 {@link Product} 接口，提供产品 A 的具体行为。</p>
 */
public class ConcreteProductA implements Product {

    /**
     * 默认构造方法。
     */
    public ConcreteProductA() {
    }

    /**
     * 产品 A 的使用行为。
     *
     * @return 描述产品 A 使用方式的字符串
     */
    @Override
    public String use() {
        return "使用具体产品 A：处理 A 类业务逻辑";
    }
}
