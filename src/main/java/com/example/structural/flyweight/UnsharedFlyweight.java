package com.example.structural.flyweight;

/**
 * 非共享享元（UnsharedFlyweight）。
 * <p>
 * 不需要或不能被共享的对象，通常作为复合享元或个性化标记。
 * 这里以"棋盘标记"为例：每个标记都携带独有信息，不适合被共享。
 */
public class UnsharedFlyweight implements Flyweight {

    /** 该对象独有的标记信息 */
    private final String marker;

    /**
     * 构造非共享享元。
     *
     * @param marker 独有标记信息
     */
    public UnsharedFlyweight(String marker) {
        this.marker = marker;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("棋盘标记 [" + marker + "] 应用在位置 " + extrinsicState
                + "（非共享，每次创建新对象）");
    }
}
