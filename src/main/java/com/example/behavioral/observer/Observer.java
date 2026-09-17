package com.example.behavioral.observer;

/**
 * 抽象观察者（Observer）。
 * 声明接收主题通知的方法，由具体观察者实现以响应主题状态变化。
 */
public interface Observer {

    /**
     * 当主题状态变化时被调用，接收主题的最新状态。
     *
     * @param state 主题的新状态
     */
    void update(String state);
}
