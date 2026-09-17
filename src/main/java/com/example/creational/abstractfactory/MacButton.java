package com.example.creational.abstractfactory;

/**
 * Mac 风格按钮（具体产品 A2）。
 *
 * <p>实现 {@link Button} 接口，提供 Mac 主题下按钮的具体外观。</p>
 */
public class MacButton implements Button {

    /**
     * 默认构造方法。
     */
    public MacButton() {
    }

    /**
     * 渲染 Mac 风格按钮。
     *
     * @return 描述 Mac 按钮外观的字符串
     */
    @Override
    public String render() {
        return "渲染 Mac 风格按钮：圆角、浅灰底、深色文字";
    }
}
