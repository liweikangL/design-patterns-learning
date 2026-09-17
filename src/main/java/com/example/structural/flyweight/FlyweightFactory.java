package com.example.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂（FlyweightFactory）。
 * <p>
 * 用一个缓存（Map）维护已创建的享元对象，按 key 复用：
 * 当请求的 key 已存在则直接返回缓存实例，否则创建并缓存。
 */
public class FlyweightFactory {

    /** 享元对象缓存池 */
    private final Map<String, Flyweight> pool = new HashMap<>();

    /**
     * 根据颜色获取享元棋子。若缓存中已有同色棋子则复用，否则新建并缓存。
     *
     * @param color 棋子颜色（内部状态）
     * @return 共享的享元对象
     */
    public Flyweight getFlyweight(String color) {
        Flyweight flyweight = pool.get(color);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(color);
            pool.put(color, flyweight);
            System.out.println("    [工厂] 新建并缓存颜色 = " + color + " 的享元对象");
        } else {
            System.out.println("    [工厂] 命中缓存，复用颜色 = " + color + " 的享元对象");
        }
        return flyweight;
    }

    /**
     * 创建非共享享元，每次返回新对象。
     *
     * @param marker 标记信息
     * @return 非共享享元对象
     */
    public Flyweight getUnsharedFlyweight(String marker) {
        return new UnsharedFlyweight(marker);
    }

    /**
     * 返回当前缓存池中享元对象的数量。
     *
     * @return 缓存的对象数
     */
    public int poolSize() {
        return pool.size();
    }
}
