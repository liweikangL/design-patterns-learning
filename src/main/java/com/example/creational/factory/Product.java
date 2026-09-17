package com.example.creational.factory;

/**
 * 工厂方法模式中的产品接口。
 *
 * <p>定义所有具体产品对外暴露的统一行为，客户端依赖此抽象，
 * 由具体工厂决定创建哪种产品实例。</p>
 */
public interface Product {

    /**
     * 产品提供的核心行为。
     *
     * @return 描述该产品的字符串
     */
    String use();
}
