package com.example.behavioral.observer;

/**
 * 具体观察者 B。
 * 收到主题通知后，以"观察者 B"的视角处理状态。
 */
public class ConcreteObserverB implements Observer {

    @Override
    public void update(String state) {
        System.out.println("观察者 B 收到更新，状态 = " + state);
    }
}
