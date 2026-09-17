package com.example.creational.abstractfactory;

/**
 * Mac 风格复选框（具体产品 B2）。
 *
 * <p>实现 {@link Checkbox} 接口，提供 Mac 主题下复选框的具体外观。</p>
 */
public class MacCheckbox implements Checkbox {

    /**
     * 默认构造方法。
     */
    public MacCheckbox() {
    }

    /**
     * 渲染 Mac 风格复选框。
     *
     * @return 描述 Mac 复选框外观的字符串
     */
    @Override
    public String render() {
        return "渲染 Mac 风格复选框：圆角、半透明背景、蓝色勾选";
    }
}
