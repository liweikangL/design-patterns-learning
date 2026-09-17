package com.example.creational.factory;

/**
 * 具体工厂 A，专门负责创建产品 A。
 *
 * <p>通过实现工厂方法返回 {@link ConcreteProductA} 的实例。</p>
 */
public class ConcreteFactoryA extends Factory {

    /**
     * 默认构造方法。
     */
    public ConcreteFactoryA() {
    }

    /**
     * 创建产品 A 的实例。
     *
     * @return 具体产品 A 实例
     */
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
