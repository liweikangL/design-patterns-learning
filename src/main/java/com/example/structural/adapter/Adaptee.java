package com.example.structural.adapter;

/**
 * 被适配者（Adaptee）。
 * <p>
 * 已经存在、功能可用但接口不兼容的类，无法直接被客户端使用。
 */
public class Adaptee {

    /**
     * 被适配者原有的方法，方法名与目标接口不一致。
     */
    public void specificRequest() {
        System.out.println("被适配者 Adaptee 的 specificRequest() 被调用，提供实际功能。");
    }
}
