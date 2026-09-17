package com.example.structural.adapter;

/**
 * 目标接口（Target）。
 * <p>
 * 客户端所期望的接口，适配器需要把被适配者转换成符合该接口的对象。
 */
public interface Target {

    /**
     * 客户端调用的方法。
     */
    void request();
}
