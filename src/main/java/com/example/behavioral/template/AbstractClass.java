package com.example.behavioral.template;

/**
 * 抽象模板类（AbstractClass）。
 * 定义算法骨架 {@link #templateMethod()}，其中调用抽象方法 {@link #primitiveOperation()}
 * 与钩子方法 {@link #hook()}，子类按需实现具体步骤。
 */
public abstract class AbstractClass {

    /**
     * 模板方法：定义算法的固定流程。
     * 该方法被声明为 final，禁止子类修改骨架。
     */
    public final void templateMethod() {
        System.out.println("【模板方法】开始执行算法骨架");
        start();
        primitiveOperation();
        if (hook()) {
            extraStep();
        }
        end();
        System.out.println("【模板方法】算法骨架执行完毕");
    }

    /**
     * 抽象方法：由子类实现具体的核心步骤。
     */
    protected abstract void primitiveOperation();

    /**
     * 钩子方法：默认返回 true；子类可覆盖以决定是否执行额外步骤。
     *
     * @return 是否执行额外步骤
     */
    protected boolean hook() {
        return true;
    }

    /**
     * 公共步骤：开始。
     */
    private void start() {
        System.out.println("  - 公共步骤：初始化");
    }

    /**
     * 公共步骤：结束。
     */
    private void end() {
        System.out.println("  - 公共步骤：收尾");
    }

    /**
     * 可选步骤，仅当钩子返回 true 时调用。
     */
    private void extraStep() {
        System.out.println("  - 可选步骤：执行扩展处理");
    }
}
