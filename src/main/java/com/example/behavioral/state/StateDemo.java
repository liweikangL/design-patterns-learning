package com.example.behavioral.state;

/**
 * 状态模式演示入口。
 * 演示上下文在启动/停止两种状态之间来回切换，由状态对象自身决定下一个状态。
 */
public class StateDemo {

    /**
     * 程序入口：演示状态模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 状态模式演示开始 =====");

        Context context = new Context(new StartState());

        // 多次调用 request，观察状态在启动/停止之间切换
        for (int i = 0; i < 4; i++) {
            System.out.println("--- 第 " + (i + 1) + " 次请求 ---");
            System.out.println("请求前：" + context.getState().name());
            context.request();
            System.out.println("请求后：" + context.getState().name());
        }

        System.out.println("===== 状态模式演示结束 =====");
    }
}
