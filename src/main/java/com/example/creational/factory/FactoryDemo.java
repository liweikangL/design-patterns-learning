package com.example.creational.factory;

/**
 * 工厂方法模式演示入口。
 *
 * <p>演示如何通过不同具体工厂创建不同的产品，而客户端只依赖
 * {@link Factory} 抽象与 {@link Product} 接口。</p>
 */
public class FactoryDemo {

    /**
     * 程序入口，演示工厂方法模式的典型用法。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("====== 工厂方法模式演示开始 ======");

        // 1. 使用具体工厂 A 创建产品 A
        System.out.println("\n[1] 通过 ConcreteFactoryA 创建并使用产品：");
        Factory factoryA = new ConcreteFactoryA();
        System.out.println(factoryA.doSomething());

        // 2. 使用具体工厂 B 创建产品 B
        System.out.println("\n[2] 通过 ConcreteFactoryB 创建并使用产品：");
        Factory factoryB = new ConcreteFactoryB();
        System.out.println(factoryB.doSomething());

        // 3. 客户端只依赖抽象工厂与产品接口
        System.out.println("\n[3] 直接调用工厂方法并使用产品接口：");
        Product product = new ConcreteFactoryA().createProduct();
        System.out.println(product.use());

        System.out.println("\n客户端代码仅依赖 Factory 抽象与 Product 接口，");
        System.out.println("新增产品只需新增对应工厂，无需修改既有逻辑（符合开闭原则）。");
        System.out.println("====== 工厂方法模式演示结束 ======");
    }
}
