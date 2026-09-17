package com.example.structural.bridge;

/**
 * 实现化角色（Implementor）。
 * <p>
 * 定义颜色维度的接口，由具体颜色实现，与形状维度解耦。
 */
public interface Color {

    /**
     * 给形状上色。
     *
     * @param shapeName 形状名称
     */
    void fillColor(String shapeName);
}
