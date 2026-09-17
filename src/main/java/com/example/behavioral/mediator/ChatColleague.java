package com.example.behavioral.mediator;

/**
 * 具体同事：聊天用户。
 * 发送消息时通过中介者转发；接收消息时打印到控制台。
 */
public class ChatColleague extends Colleague {

    /**
     * 构造方法。
     *
     * @param mediator 中介者
     * @param name     用户姓名
     */
    public ChatColleague(Mediator mediator, String name) {
        super(mediator, name);
    }

    /**
     * 发送消息：通过中介者转发。
     *
     * @param message 消息内容
     */
    @Override
    public void send(String message) {
        System.out.println(name + " 发送：" + message);
        mediator.sendMessage(message, this);
    }

    /**
     * 接收消息并打印。
     *
     * @param message 消息内容
     */
    @Override
    public void receive(String message) {
        System.out.println(name + " 收到：" + message);
    }
}
