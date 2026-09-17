package com.example.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题（Subject）。
 * 维护观察者集合，提供注册、移除和通知观察者的方法。
 */
public abstract class Subject {

    /** 已注册的观察者列表 */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者。
     *
     * @param observer 观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者。
     *
     * @param observer 观察者
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有观察者，将当前状态推送给它们。
     *
     * @param state 当前状态
     */
    protected void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
