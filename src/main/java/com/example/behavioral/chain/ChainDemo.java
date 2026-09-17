package com.example.behavioral.chain;

/**
 * 责任链模式演示入口。
 * 组装链路 A -> B -> C，依次发起不同级别的请求，
 * 展示请求如何被对应处理者处理或最终由 C 兜底。
 */
public class ChainDemo {

    /**
     * 程序入口：演示责任链模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 责任链模式演示开始 =====");

        // 组装责任链：A -> B -> C（兜底）
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();
        handlerA.setNext(handlerB);
        handlerB.setNext(handlerC);

        // 测试不同级别的请求
        int[] levels = {5, 15, 25};
        for (int level : levels) {
            System.out.println("--- 发起请求，级别 = " + level + " ---");
            handlerA.handleRequest(level);
        }

        System.out.println("===== 责任链模式演示结束 =====");
    }
}
