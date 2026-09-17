package com.example.behavioral.chain;

/**
 * 具体处理者 A。
 * 负责处理级别小于等于 10 的请求；否则将请求传递给后继者。
 */
public class ConcreteHandlerA extends Handler {

    /**
     * 处理级别小于等于 10 的请求，否则传递给后继者。
     *
     * @param level 请求级别
     */
    @Override
    public void handleRequest(int level) {
        if (level <= 10) {
            System.out.println("ConcreteHandlerA 处理了请求，级别 = " + level);
        } else if (next != null) {
            System.out.println("ConcreteHandlerA 无法处理级别 " + level + "，传递给下一个处理者");
            next.handleRequest(level);
        }
    }
}
