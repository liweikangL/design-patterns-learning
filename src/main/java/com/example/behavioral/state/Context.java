package com.example.behavioral.state;

/**
 * 状态上下文（Context）。
 * 维护当前状态，并把状态相关行为委托给当前状态对象。
 */
public class Context {

    /** 当前状态 */
    private State state;

    /**
     * 构造方法，注入初始状态。
     *
     * @param state 初始状态
     */
    public Context(State state) {
        this.state = state;
    }

    /**
     * 获取当前状态。
     *
     * @return 当前状态
     */
    public State getState() {
        return state;
    }

    /**
     * 设置当前状态。
     *
     * @param state 新状态
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 委托当前状态处理请求；状态切换由具体状态对象自行决定。
     */
    public void request() {
        state.handle(this);
    }
}
