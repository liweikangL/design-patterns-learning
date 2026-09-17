package com.example.behavioral.memento;

/**
 * 备忘录（Memento）。
 * 保存发起人对象某一时刻的内部状态，仅供发起人读取。
 */
public class Memento {

    /** 保存的状态 */
    private final String state;

    /**
     * 构造方法。
     *
     * @param state 待保存的状态
     */
    public Memento(String state) {
        this.state = state;
    }

    /**
     * 获取保存的状态。
     *
     * @return 状态字符串
     */
    public String getState() {
        return state;
    }
}
