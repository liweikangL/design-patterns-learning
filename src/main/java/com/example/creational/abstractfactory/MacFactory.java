package com.example.creational.abstractfactory;

/**
 * Mac 主题工厂（具体工厂 2）。
 *
 * <p>实现 {@link GUIFactory}，统一返回 Mac 风格的按钮与复选框，
 * 保证所创建的产品属于同一产品族。</p>
 */
public class MacFactory implements GUIFactory {

    /**
     * 默认构造方法。
     */
    public MacFactory() {
    }

    /**
     * 创建 Mac 风格按钮。
     *
     * @return Mac 按钮实例
     */
    @Override
    public Button createButton() {
        return new MacButton();
    }

    /**
     * 创建 Mac 风格复选框。
     *
     * @return Mac 复选框实例
     */
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
