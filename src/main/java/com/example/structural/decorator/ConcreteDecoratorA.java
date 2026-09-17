package com.example.structural.decorator;

/**
 * 具体装饰器 A（ConcreteDecoratorA）。
 * <p>
 * 在被装饰构件基础上添加"状态 A"（addedState），演示装饰器可叠加状态。
 */
public class ConcreteDecoratorA extends Decorator {

    /** 由该装饰器添加的状态字段 */
    private final String addedState;

    /**
     * 构造装饰器 A。
     *
     * @param component  被装饰构件
     * @param addedState 添加的状态描述
     */
    public ConcreteDecoratorA(Component component, String addedState) {
        super(component);
        this.addedState = addedState;
    }

    @Override
    public String operation() {
        return "[" + addedState + "] " + super.operation();
    }
}
