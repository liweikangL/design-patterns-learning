package com.example.structural.adapter;

/**
 * 对象适配器（ObjectAdapter）。
 * <p>
 * 通过组合方式持有被适配者实例，并将其方法转换为符合 {@link Target} 接口的形式。
 * 推荐使用对象适配器，因为它遵循"合成复用原则"，且可适配 Adaptee 的子类。
 */
public class ObjectAdapter implements Target {

    /** 被适配者实例，通过组合方式持有 */
    private final Adaptee adaptee;

    /**
     * 构造对象适配器，注入被适配者。
     *
     * @param adaptee 被适配者实例
     */
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("对象适配器：将 request() 委托给 Adaptee.specificRequest()");
        adaptee.specificRequest();
    }
}
