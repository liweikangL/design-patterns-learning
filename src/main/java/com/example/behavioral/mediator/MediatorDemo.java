package com.example.behavioral.mediator;

/**
 * 中介者模式演示入口。
 * 创建一个聊天室中介者，注册若干用户，并让用户通过中介者互相通信。
 */
public class MediatorDemo {

    /**
     * 程序入口：演示中介者模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 中介者模式演示开始 =====");

        // 创建中介者（聊天室）
        ChatMediator chatRoom = new ChatMediator();

        // 创建同事（用户），注入中介者
        Colleague alice = new ChatColleague(chatRoom, "张三");
        Colleague bob = new ChatColleague(chatRoom, "李四");
        Colleague carol = new ChatColleague(chatRoom, "王五");

        // 注册到聊天室
        chatRoom.addColleague(alice);
        chatRoom.addColleague(bob);
        chatRoom.addColleague(carol);

        // 通过中介者互相通信
        alice.send("大家好！");
        bob.send("你好，张三。");

        System.out.println("===== 中介者模式演示结束 =====");
    }
}
