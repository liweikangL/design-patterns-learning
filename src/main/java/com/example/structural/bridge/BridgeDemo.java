package com.example.structural.bridge;

/**
 * 桥接模式演示入口。
 * <p>
 * 演示形状维度与颜色维度解耦后可自由组合。
 */
public class BridgeDemo {

    /**
     * 程序入口，演示桥接模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 桥接模式演示 =====");

        // 准备两个颜色实现
        Color red = new RedColor();
        Color blue = new BlueColor();

        // 1. 红色形状
        System.out.println("\n【1】红色形状：");
        Shape redShape = new RefinedShape("圆形", red);
        redShape.draw();

        // 2. 蓝色形状
        System.out.println("\n【2】蓝色形状：");
        Shape blueShape = new RefinedShape("方形", blue);
        blueShape.draw();

        // 3. 同一形状切换颜色，无需新增子类
        System.out.println("\n【3】同一形状切换颜色：");
        Shape squareWithRed = new RefinedShape("三角形", red);
        squareWithRed.draw();
        Shape squareWithBlue = new RefinedShape("三角形", blue);
        squareWithBlue.draw();

        System.out.println("\n形状与颜色两个维度独立变化，互不影响，子类数量从 m*n 降为 m+n。");
    }
}
