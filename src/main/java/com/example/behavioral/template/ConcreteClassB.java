package com.example.behavioral.template;

/**
 * 具体子类 B。
 * 实现 {@link #primitiveOperation()} 提供本子类特有的核心步骤，
 * 并覆盖钩子方法使其返回 false 以跳过额外步骤。
 */
public class ConcreteClassB extends AbstractClass {

    /**
     * 实现具体核心步骤 B。
     */
    @Override
    protected void primitiveOperation() {
        System.out.println("  - 具体类 B：执行核心步骤（如解析 JSON 配置）");
    }

    /**
     * 覆盖钩子方法，禁用额外步骤。
     *
     * @return false
     */
    @Override
    protected boolean hook() {
        return false;
    }
}
