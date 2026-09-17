package com.example.creational.abstractfactory;

/**
 * 抽象工厂：GUI 工厂。
 *
 * <p>声明一族创建相关 UI 组件（按钮、复选框）的工厂方法。
 * 同一个具体工厂所创建的所有组件保证属于同一主题风格，
 * 客户端依赖此抽象即可获得一族相互协调的产品。</p>
 */
public interface GUIFactory {

    /**
     * 创建按钮。
     *
     * @return 与当前工厂主题匹配的按钮实例
     */
    Button createButton();

    /**
     * 创建复选框。
     *
     * @return 与当前工厂主题匹配的复选框实例
     */
    Checkbox createCheckbox();
}
