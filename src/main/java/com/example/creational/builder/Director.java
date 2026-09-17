package com.example.creational.builder;

/**
 * 指挥者：封装常用产品的构建顺序。
 *
 * <p>调用方传入建造者，由 Director 调度各 build 步骤的顺序与默认值，
 * 将"如何分步构建"与"如何实现每一步"分离。</p>
 *
 * <p>典型用法包括构建"标准款"和"促销款"两种产品，
 * 演示同一建造者配合不同构建顺序产生不同结果。</p>
 */
public class Director {

    /**
     * 构建一款标准产品：基础名称 + 描述 + 默认价格。
     *
     * @param builder 建造者实例
     * @return 装配好的产品
     */
    public Product buildStandard(Builder<Product> builder) {
        return builder.reset()
                .buildPartA("标准款商品")
                .buildPartB("日常销售的标准商品")
                .buildPartC(99.0)
                .build();
    }

    /**
     * 构建一款促销产品：基础名称 + 促销描述 + 折扣价。
     *
     * @param builder 建造者实例
     * @return 装配好的产品
     */
    public Product buildPromotion(Builder<Product> builder) {
        return builder.reset()
                .buildPartA("促销款商品")
                .buildPartB("限时折扣的促销商品")
                .buildPartC(59.0)
                .build();
    }
}
