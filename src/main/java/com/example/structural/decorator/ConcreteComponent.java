package com.example.structural.decorator;

/**
 * 具体构件（ConcreteComponent）。
 * <p>
 * 提供最基础的功能实现，是被装饰的原始对象。
 */
public class ConcreteComponent implements Component {

    @Override
    public String operation() {
        return "基础功能";
    }
}
