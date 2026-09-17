package com.example.behavioral.observer;

/**
 * 具体主题（ConcreteSubject）。
 * 维护一个状态，状态变化时通知所有已注册观察者。
 */
public class ConcreteSubject extends Subject {

    /** 当前状态 */
    private String state;

    /**
     * 获取当前状态。
     *
     * @return 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 修改状态并通知所有观察者。
     *
     * @param state 新状态
     */
    public void setState(String state) {
        this.state = state;
        System.out.println("主题状态变更为：" + state);
        notifyObservers(state);
    }
}
