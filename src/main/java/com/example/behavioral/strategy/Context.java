package com.example.behavioral.strategy;

/**
 * 上下文（Context）。
 * 持有当前策略引用，可在运行时被替换为不同策略，
 * 把运算调用委托给当前策略。
 */
public class Context {

    /** 当前策略 */
    private Strategy strategy;

    /**
     * 构造方法，注入初始策略。
     *
     * @param strategy 策略
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 在运行时切换策略。
     *
     * @param strategy 新策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 委托当前策略执行运算。
     *
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return 运算结果
     */
    public int execute(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
