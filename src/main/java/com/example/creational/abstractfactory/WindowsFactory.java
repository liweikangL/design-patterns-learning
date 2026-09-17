package com.example.creational.abstractfactory;

/**
 * Windows 主题工厂（具体工厂 1）。
 *
 * <p>实现 {@link GUIFactory}，统一返回 Windows 风格的按钮与复选框，
 * 保证所创建的产品属于同一产品族。</p>
 */
public class WindowsFactory implements GUIFactory {

    /**
     * 默认构造方法。
     */
    public WindowsFactory() {
    }

    /**
     * 创建 Windows 风格按钮。
     *
     * @return Windows 按钮实例
     */
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    /**
     * 创建 Windows 风格复选框。
     *
     * @return Windows 复选框实例
     */
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
