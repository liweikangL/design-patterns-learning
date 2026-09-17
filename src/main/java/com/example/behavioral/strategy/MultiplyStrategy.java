package com.example.behavioral.strategy;

/**
 * 具体策略：乘法策略。
 */
public class MultiplyStrategy implements Strategy {

    /**
     * 计算两数之积。
     *
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return a * b
     */
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
