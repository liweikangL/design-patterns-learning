package com.example.structural.bridge;

/**
 * 扩展抽象化（RefinedAbstraction）。
 * <p>
 * 在抽象化基础上扩展行为：先绘制形状轮廓，再通过桥接的颜色实现上色，
 * 并提供额外的"装饰边框"等扩展能力。
 */
public class RefinedShape extends Shape {

    /**
     * 构造扩展抽象化形状。
     *
     * @param name  形状名称
     * @param color 颜色实现
     */
    public RefinedShape(String name, Color color) {
        super(name, color);
    }

    @Override
    public void draw() {
        System.out.println("绘制 " + name + " 的轮廓");
        color.fillColor(name);
        drawBorder();
    }

    /**
     * 扩展方法：为形状添加边框。
     */
    public void drawBorder() {
        System.out.println("为 " + name + " 添加装饰边框");
    }
}
