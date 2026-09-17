package com.example.structural.bridge;

/**
 * 抽象化角色（Abstraction）。
 * <p>
 * 持有 {@link Color} 实现化接口的引用，将"形状"维度与"颜色"维度桥接，
 * 避免因两维度组合产生子类爆炸（如 RedCircle、BlueCircle、RedSquare...）。
 */
public abstract class Shape {

    /** 桥接到实现化角色的引用 */
    protected final Color color;

    /** 形状名称 */
    protected final String name;

    /**
     * 构造形状并注入颜色实现。
     *
     * @param name  形状名称
     * @param color 颜色实现化对象
     */
    public Shape(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * 抽象方法，由扩展抽象化实现，负责调用颜色实现完成上色。
     */
    public abstract void draw();
}
