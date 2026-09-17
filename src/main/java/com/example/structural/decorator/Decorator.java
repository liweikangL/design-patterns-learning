package com.example.structural.decorator;

/**
 * 抽象装饰器（Decorator）。
 * <p>
 * 实现 {@link Component} 接口，同时持有一个 {@link Component} 引用，
 * 通过组合而非继承包装被装饰对象，并委派调用其方法。
 */
public abstract class Decorator implements Component {

    /** 被装饰的构件 */
    protected final Component component;

    /**
     * 构造装饰器，注入被装饰构件。
     *
     * @param component 被装饰构件
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        // 默认行为：直接委派给被装饰构件
        return component.operation();
    }
}
