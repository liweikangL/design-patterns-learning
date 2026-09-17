package com.example.structural.adapter;

/**
 * 类适配器（ClassAdapter）。
 * <p>
 * 通过继承被适配者 {@link Adaptee} 并实现目标接口 {@link Target} 完成适配。
 * 优点是可直接重写 Adaptee 的方法，缺点是无法适配 Adaptee 的子类实例，
 * 且 Java 单继承机制要求 Adaptee 不能再被其他适配器继承复用。
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        System.out.println("类适配器：继承 Adaptee 并实现 Target，调用 specificRequest()");
        specificRequest();
    }
}
