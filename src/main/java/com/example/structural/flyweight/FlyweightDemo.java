package com.example.structural.flyweight;

/**
 * 享元模式演示入口。
 * <p>
 * 以围棋棋盘为例，演示内部状态（颜色）共享、外部状态（位置）分离。
 */
public class FlyweightDemo {

    /**
     * 程序入口，演示享元模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 享元模式演示（围棋棋盘） =====");

        FlyweightFactory factory = new FlyweightFactory();

        String[] positions = {
                "A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2"
        };
        String[] colors = {
                "黑", "白", "黑", "白", "黑", "白", "黑", "白"
        };

        System.out.println("\n【1】在多个位置落子，颜色交替：");
        for (int i = 0; i < positions.length; i++) {
            System.out.println("--- 第 " + (i + 1) + " 步 ---");
            Flyweight stone = factory.getFlyweight(colors[i]);
            // 外部状态（位置）作为参数传入，不存储在享元中
            stone.operation(positions[i]);
        }

        System.out.println("\n【2】共享与非共享对比：");
        // 共享：两个相同颜色的棋子实际是同一对象
        Flyweight black1 = factory.getFlyweight("黑");
        Flyweight black2 = factory.getFlyweight("黑");
        System.out.println("    两次获取'黑'是否为同一对象 = " + (black1 == black2));
        black1.operation("D5");

        // 非共享：每次返回新对象
        Flyweight unshared1 = factory.getUnsharedFlyweight("星位标记");
        Flyweight unshared2 = factory.getUnsharedFlyweight("星位标记");
        System.out.println("    两次获取非共享是否为同一对象 = " + (unshared1 == unshared2));
        unshared1.operation("天元");

        System.out.println("\n【3】统计：");
        System.out.println("    共落子 " + positions.length + " 步，"
                + "享元缓存池中实际对象数 = " + factory.poolSize() + "（仅黑白两种）");

        System.out.println("\n享元模式通过共享内部状态，显著减少对象数量；外部状态由调用方传入。");
    }
}
