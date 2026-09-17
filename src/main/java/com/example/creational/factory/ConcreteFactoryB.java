package com.example.creational.factory;

/**
 * 具体工厂 B，专门负责创建产品 B。
 *
 * <p>通过实现工厂方法返回 {@link ConcreteProductB} 的实例。</p>
 */
public class ConcreteFactoryB extends Factory {

    /**
     * 默认构造方法。
     */
    public ConcreteFactoryB() {
    }

    /**
     * 创建产品 B 的实例。
     *
     * @return 具体产品 B 实例
     */
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
