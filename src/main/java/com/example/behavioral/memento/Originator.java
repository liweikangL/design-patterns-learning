package com.example.behavioral.memento;

/**
 * 发起人（Originator）。
 * 持有当前状态，并能创建备忘录保存自身状态或从备忘录恢复状态。
 */
public class Originator {

    /** 当前状态 */
    private String state;

    /**
     * 设置当前状态。
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取当前状态。
     *
     * @return 状态字符串
     */
    public String getState() {
        return state;
    }

    /**
     * 创建保存当前状态的备忘录。
     *
     * @return 备忘录实例
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 从备忘录恢复状态。
     *
     * @param memento 备忘录
     */
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
