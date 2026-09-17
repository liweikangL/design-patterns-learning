package com.example.structural.flyweight;

/**
 * 具体享元（ConcreteFlyweight）。
 * <p>
 * 以"围棋棋子"为例，内部状态为颜色（黑/白），可在棋盘上共享同一对象；
 * 外部状态为落子位置，由调用方在 {@link #operation(String)} 时传入。
 */
public class ConcreteFlyweight implements Flyweight {

    /** 内部状态：棋子颜色，被所有同色棋子共享 */
    private final String color;

    /**
     * 构造具体享元，传入内部状态。
     *
     * @param color 棋子颜色（黑/白）
     */
    public ConcreteFlyweight(String color) {
        this.color = color;
    }

    /**
     * 获取内部状态（颜色）。
     *
     * @return 棋子颜色
     */
    public String getColor() {
        return color;
    }

    @Override
    public void operation(String extrinsicState) {
        // 内部状态 color 与外部状态 position 组合，共同描述一个棋子
        System.out.println("在棋盘 " + extrinsicState + " 落下 " + color + " 棋子，"
                + "本对象内部状态 = [" + color + "]");
    }
}
