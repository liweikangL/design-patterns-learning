package com.example.creational.factory;

/**
 * 工厂方法模式中的工厂抽象。
 *
 * <p>声明工厂方法 {@link #createProduct()}，由具体子类决定实例化哪个产品。
 * 客户端依赖此抽象而非具体实现，从而将"对象创建"与"对象使用"解耦。</p>
 *
 * <p>这是经典的工厂方法模式实现：父类定义创建逻辑的骨架，
 * 子类实现具体创建细节。</p>
 */
public abstract class Factory {

    /**
     * 工厂方法：由子类实现，决定创建哪种具体产品。
     *
     * @return 具体产品实例
     */
    public abstract Product createProduct();

    /**
     * 模板方法：封装"创建 -> 使用"的通用流程。
     * 子类只需覆盖工厂方法，无需关心调用顺序。
     *
     * @return 产品使用结果
     */
    public String doSomething() {
        Product product = createProduct();
        return product.use();
    }
}
