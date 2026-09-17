package com.example.behavioral.strategy;

/**
 * 策略接口（Strategy）。
 * 声明对两个整数执行某种运算的方法，由具体策略实现。
 */
public interface Strategy {

    /**
     * 执行具体的运算。
     *
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return 运算结果
     */
    int doOperation(int a, int b);
}
