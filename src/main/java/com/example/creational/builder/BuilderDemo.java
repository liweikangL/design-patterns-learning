package com.example.creational.builder;

/**
 * 建造者模式演示入口。
 *
 * <p>演示两种典型用法：</p>
 * <ol>
 *   <li>由 {@link Director} 封装构建顺序，生成标准款 / 促销款产品；</li>
 *   <li>由客户端直接链式调用 {@link ConcreteBuilder#chain()} 自由装配产品。</li>
 * </ol>
 */
public class BuilderDemo {

    /**
     * 程序入口，演示建造者模式的典型用法。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("====== 建造者模式演示开始 ======");

        // 1. 通过 Director 构建标准款产品
        System.out.println("\n[1] 由 Director 构建标准款产品：");
        Director director = new Director();
        ConcreteBuilder builder = new ConcreteBuilder();
        Product standard = director.buildStandard(builder);
        System.out.println(standard);

        // 2. 通过 Director 构建促销款产品
        System.out.println("\n[2] 由 Director 构建促销款产品：");
        Product promotion = director.buildPromotion(builder);
        System.out.println(promotion);

        // 3. 客户端直接链式装配自定义产品
        System.out.println("\n[3] 客户端直接链式调用建造者自定义产品：");
        Product custom = new ConcreteBuilder()
                .chain("定制款商品")
                .setDescription("客户自定义的特别商品")
                .setPrice(188.0)
                .setStock(50)
                .setOnSale(true)
                .build();
        System.out.println(custom);

        System.out.println("\n建造者模式将复杂对象分步构建与最终装配分离，");
        System.out.println("Director 封装常用构建顺序，客户端也可直接链式自定义。");
        System.out.println("====== 建造者模式演示结束 ======");
    }
}
