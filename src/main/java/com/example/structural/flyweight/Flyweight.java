package com.example.structural.flyweight;

/**
 * 享元接口（Flyweight）。
 * <p>
 * 定义共享对象的统一接口。享元把状态分为：
 * <ul>
 *   <li>内部状态（intrinsic）：可被多个对象共享，存储在享元内部。</li>
 *   <li>外部状态（extrinsic）：随上下文变化，由客户端传入，不存储在享元中。</li>
 * </ul>
 */
public interface Flyweight {

    /**
     * 业务方法：展示享元，外部状态作为参数传入。
     *
     * @param extrinsicState 外部状态（如棋子的位置坐标）
     */
    void operation(String extrinsicState);
}
