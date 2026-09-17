package com.example.behavioral.chain;

/**
 * 抽象处理者（Handler）。
 * 定义处理请求的接口，并持有下一个处理者（后继者）的引用，
 * 子类通过实现 {@link #handleRequest(int)} 决定是否处理请求或继续传递。
 */
public abstract class Handler {

    /** 后继处理者 */
    protected Handler next;

    /**
     * 设置后继处理者。
     *
     * @param next 下一个处理者
     * @return 返回下一个处理者，便于链式组装
     */
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    /**
     * 处理请求的核心方法。
     * 默认实现：若存在后继者，则将请求传递下去。
     *
     * @param level 请求级别
     */
    public abstract void handleRequest(int level);
}
