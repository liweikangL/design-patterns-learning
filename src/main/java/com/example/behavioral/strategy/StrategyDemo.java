package com.example.behavioral.strategy;

/**
 * 策略模式演示入口。
 * 演示在运行时切换加、减、乘三种策略完成不同运算。
 */
public class StrategyDemo {

    /**
     * 程序入口：演示策略模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 策略模式演示开始 =====");

        int a = 10;
        int b = 5;

        // 初始使用加法策略
        Context context = new Context(new AddStrategy());
        System.out.println("加法：" + a + " + " + b + " = " + context.execute(a, b));

        // 运行时切换为减法策略
        context.setStrategy(new SubtractStrategy());
        System.out.println("减法：" + a + " - " + b + " = " + context.execute(a, b));

        // 运行时切换为乘法策略
        context.setStrategy(new MultiplyStrategy());
        System.out.println("乘法：" + a + " * " + b + " = " + context.execute(a, b));

        System.out.println("===== 策略模式演示结束 =====");
    }
}
