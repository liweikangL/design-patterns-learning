package com.example.creational.builder;

/**
 * 复杂产品对象。
 *
 * <p>包含多个可选属性，其构造过程较为繁琐，适合用建造者模式逐步装配。
 * 字段默认为不可变（{@code final}），由 {@link Builder} 在构建过程中赋值。</p>
 */
public class Product {

    /** 必填属性：产品名称。 */
    private final String name;

    /** 可选属性：产品描述。 */
    private final String description;

    /** 可选属性：产品价格。 */
    private final double price;

    /** 可选属性：产品库存数量。 */
    private final int stock;

    /** 可选属性：是否上架。 */
    private final boolean onSale;

    /**
     * 通过建造者构造产品，所有字段一次性赋值。
     *
     * @param builder 提供全部字段值的建造者
     */
    private Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
        this.onSale = builder.onSale;
    }

    /**
     * 返回产品名称。
     *
     * @return 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 返回产品描述。
     *
     * @return 产品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 返回产品价格。
     *
     * @return 产品价格
     */
    public double getPrice() {
        return price;
    }

    /**
     * 返回库存数量。
     *
     * @return 库存数量
     */
    public int getStock() {
        return stock;
    }

    /**
     * 返回是否上架。
     *
     * @return 上架状态
     */
    public boolean isOnSale() {
        return onSale;
    }

    /**
     * 返回产品摘要信息，便于演示输出。
     *
     * @return 产品摘要字符串
     */
    @Override
    public String toString() {
        return "Product{name='" + name + "', description='" + description
                + "', price=" + price + ", stock=" + stock + ", onSale=" + onSale + "}";
    }

    /**
     * 产品建造者，提供链式 API 逐步装配复杂产品。
     *
     * <p>必填字段 {@code name} 在构造时指定，其余可选字段通过同名 setter 链式设置，
     * 最后调用 {@link #build()} 返回不可变产品实例。</p>
     */
    public static class Builder {

        private final String name;
        private String description;
        private double price;
        private int stock;
        private boolean onSale;

        /**
         * 创建建造者并指定必填字段。
         *
         * @param name 产品名称（必填）
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * 设置产品描述，支持链式调用。
         *
         * @param description 产品描述
         * @return 当前建造者实例
         */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * 设置产品价格，支持链式调用。
         *
         * @param price 产品价格
         * @return 当前建造者实例
         */
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        /**
         * 设置库存数量，支持链式调用。
         *
         * @param stock 库存数量
         * @return 当前建造者实例
         */
        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        /**
         * 设置是否上架，支持链式调用。
         *
         * @param onSale 上架状态
         * @return 当前建造者实例
         */
        public Builder setOnSale(boolean onSale) {
            this.onSale = onSale;
            return this;
        }

        /**
         * 装配并返回不可变产品实例。
         *
         * @return 已装配的产品实例
         */
        public Product build() {
            return new Product(this);
        }
    }
}
