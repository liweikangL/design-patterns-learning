package com.example.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者：聊天室中介者。
 * 维护所有同事列表，并把发送者的消息广播给除自己以外的其他同事。
 */
public class ChatMediator implements Mediator {

    /** 聊天室中的同事列表 */
    private final List<Colleague> colleagues = new ArrayList<>();

    /**
     * 添加同事到聊天室。
     *
     * @param colleague 同事
     */
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    /**
     * 将发送者的消息转发给聊天室中的其他同事。
     *
     * @param message 消息内容
     * @param sender  发送者
     */
    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            // 不回送给自己
            if (colleague != sender) {
                colleague.receive(message);
            }
        }
    }
}
