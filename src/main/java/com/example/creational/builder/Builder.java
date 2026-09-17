package com.example.creational.builder;

/**
 * 抽象建造者接口。
 *
 * <p>声明构建一个复杂产品各部分的步骤，由具体建造者实现。
 * 这种抽象允许 {@link Director} 不感知具体建造者类型，
 * 复用同一套构建流程生成不同形态的产品。</p>
 *
 * @param <T> 最终生成的产品类型
 */
public interface Builder<T> {

    /**
     * 重置建造者状态，开始新一轮装配。
     *
     * @return 当前建造者实例
     */
    Builder<T> reset();

    /**
     * 装配产品基础部分（如名称）。
     *
     * @param name 基础字段值
     * @return 当前建造者实例
     */
    Builder<T> buildPartA(String name);

    /**
     * 装配产品可选部分（如描述）。
     *
     * @param description 可选字段值
     * @return 当前建造者实例
     */
    Builder<T> buildPartB(String description);

    /**
     * 装配产品可选部分（如价格）。
     *
     * @param price 可选字段值
     * @return 当前建造者实例
     */
    Builder<T> buildPartC(double price);

    /**
     * 返回最终装配好的产品。
     *
     * @return 装配完成的产品实例
     */
    T build();
}
