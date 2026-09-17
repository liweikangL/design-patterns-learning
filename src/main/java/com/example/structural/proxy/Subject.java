package com.example.structural.proxy;

/**
 * 抽象主题（Subject）。
 * <p>
 * 声明真实主题与代理共有的接口，使代理可以在任何使用真实主题的地方被透明替换。
 */
public interface Subject {

    /**
     * 业务方法：执行请求。
     */
    void request();
}
