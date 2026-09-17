package com.example.creational.factory;

/**
 * 具体产品 B。
 *
 * <p>实现 {@link Product} 接口，提供产品 B 的具体行为。</p>
 */
public class ConcreteProductB implements Product {

    /**
     * 默认构造方法。
     */
    public ConcreteProductB() {
    }

    /**
     * 产品 B 的使用行为。
     *
     * @return 描述产品 B 使用方式的字符串
     */
    @Override
    public String use() {
        return "使用具体产品 B：处理 B 类业务逻辑";
    }
}
