package com.example.behavioral.mediator;

/**
 * 抽象中介者（Mediator）。
 * 定义与同事对象交互的接口，由具体中介者实现。
 */
public interface Mediator {

    /**
     * 将一条消息从指定同事转发给其他同事。
     *
     * @param message 消息内容
     * @param sender  发送者
     */
    void sendMessage(String message, Colleague sender);
}
