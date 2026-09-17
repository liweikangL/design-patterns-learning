package com.example.behavioral.chain;

/**
 * 具体处理者 C（兜底处理者）。
 * 作为链的末端，对所有未被前序处理者处理的请求进行兜底处理，
 * 保证请求不会到达链尾仍未被处理。
 */
public class ConcreteHandlerC extends Handler {

    /**
     * 兜底处理所有请求。
     *
     * @param level 请求级别
     */
    @Override
    public void handleRequest(int level) {
        System.out.println("ConcreteHandlerC 兜底处理了请求，级别 = " + level);
    }
}
