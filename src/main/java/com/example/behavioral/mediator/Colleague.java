package com.example.behavioral.mediator;

/**
 * 抽象同事（Colleague）。
 * 每个同事都持有中介者引用，与其他同事通信时通过中介者转发，
 * 避免同事之间直接耦合。
 */
public abstract class Colleague {

    /** 中介者引用 */
    protected Mediator mediator;

    /** 同事姓名 */
    protected final String name;

    /**
     * 构造方法。
     *
     * @param mediator 中介者
     * @param name     同事姓名
     */
    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 获取同事姓名。
     *
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 发送消息：通过中介者转发给其他同事。
     *
     * @param message 消息内容
     */
    public abstract void send(String message);

    /**
     * 接收来自其他同事的消息。
     *
     * @param message 消息内容
     */
    public abstract void receive(String message);
}
