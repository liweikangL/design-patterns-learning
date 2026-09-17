package com.example.creational.builder;

/**
 * 具体建造者：基于 {@link Product.Builder} 实现 {@link Builder} 接口。
 *
 * <p>实现所有构建步骤，并对外暴露链式 API，最终产出 {@link Product} 实例。</p>
 */
public class ConcreteBuilder implements Builder<Product> {

    /** 内部委托的产品建造者，复用其链式能力。 */
    private Product.Builder productBuilder;

    /**
     * 默认构造方法，初始化时调用 reset 准备空状态。
     */
    public ConcreteBuilder() {
        reset();
    }

    /**
     * 重置建造者状态，开始新一轮装配。
     *
     * @return 当前建造者实例
     */
    @Override
    public Builder<Product> reset() {
        // 暂以占位名称初始化，buildPartA 会真正设置
        this.productBuilder = new Product.Builder("(未命名)");
        return this;
    }

    /**
     * 设置产品名称（必填部分）。
     *
     * <p>由于 {@link Product.Builder} 的 {@code name} 字段在构造时确定且不可变，
     * 此处通过重新创建建造者来替换名称。Director 通常在 reset 后首先调用本方法，
     * 故无需保留其他字段状态。</p>
     *
     * @param name 产品名称
     * @return 当前建造者实例
     */
    @Override
    public Builder<Product> buildPartA(String name) {
        this.productBuilder = new Product.Builder(name);
        return this;
    }

    /**
     * 设置产品描述。
     *
     * @param description 产品描述
     * @return 当前建造者实例
     */
    @Override
    public Builder<Product> buildPartB(String description) {
        this.productBuilder.setDescription(description);
        return this;
    }

    /**
     * 设置产品价格。
     *
     * @param price 产品价格
     * @return 当前建造者实例
     */
    @Override
    public Builder<Product> buildPartC(double price) {
        this.productBuilder.setPrice(price);
        return this;
    }

    /**
     * 装配并返回产品实例。
     *
     * @return 已装配的产品实例
     */
    @Override
    public Product build() {
        return productBuilder.build();
    }

    /**
     * 直接暴露底层链式建造者，便于客户端不通过 Director 直接链式装配。
     *
     * @return 底层产品建造者
     */
    public Product.Builder chain() {
        return this.productBuilder;
    }

    /**
     * 以指定名称初始化并返回底层链式建造者，便于客户端直接链式装配。
     *
     * @param name 产品名称（必填）
     * @return 已设置名称的产品建造者
     */
    public Product.Builder chain(String name) {
        this.productBuilder = new Product.Builder(name);
        return this.productBuilder;
    }
}
