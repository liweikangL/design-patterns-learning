package com.example.behavioral.template;

/**
 * 具体子类 A。
 * 实现 {@link #primitiveOperation()} 提供本子类特有的核心步骤，
 * 并覆盖钩子方法使其返回 true 以执行额外步骤。
 */
public class ConcreteClassA extends AbstractClass {

    /**
     * 实现具体核心步骤 A。
     */
    @Override
    protected void primitiveOperation() {
        System.out.println("  - 具体类 A：执行核心步骤（如解析 XML 配置）");
    }

    /**
     * 覆盖钩子方法，启用额外步骤。
     *
     * @return true
     */
    @Override
    protected boolean hook() {
        return true;
    }
}
