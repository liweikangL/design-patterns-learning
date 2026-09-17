package com.example.structural.decorator;

/**
 * 具体装饰器 B（ConcreteDecoratorB）。
 * <p>
 * 在被装饰构件基础上添加额外行为（addedBehavior），
 * 演示装饰器可叠加行为，且可任意组合使用顺序。
 */
public class ConcreteDecoratorB extends Decorator {

    /**
     * 构造装饰器 B。
     *
     * @param component 被装饰构件
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        return addedBehavior() + super.operation();
    }

    /**
     * 该装饰器新增的行为方法。
     *
     * @return 新增行为描述
     */
    private String addedBehavior() {
        return "加糖(行为B)+";
    }
}
