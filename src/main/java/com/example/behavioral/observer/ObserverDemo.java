package com.example.behavioral.observer;

/**
 * 观察者模式演示入口。
 * 演示注册多个观察者并在主题状态变化时通知所有观察者。
 */
public class ObserverDemo {

    /**
     * 程序入口：演示观察者模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 观察者模式演示开始 =====");

        ConcreteSubject subject = new ConcreteSubject();

        // 注册两个观察者
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();
        subject.attach(observerA);
        subject.attach(observerB);

        // 状态变化时通知所有观察者
        subject.setState("在线");
        subject.setState("离线");

        // 移除观察者 A 后再次变更
        subject.detach(observerA);
        subject.setState("忙碌");

        System.out.println("===== 观察者模式演示结束 =====");
    }
}
