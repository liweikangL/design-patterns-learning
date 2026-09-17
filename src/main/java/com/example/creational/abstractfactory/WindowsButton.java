package com.example.creational.abstractfactory;

/**
 * Windows 风格按钮（具体产品 A1）。
 *
 * <p>实现 {@link Button} 接口，提供 Windows 主题下按钮的具体外观。</p>
 */
public class WindowsButton implements Button {

    /**
     * 默认构造方法。
     */
    public WindowsButton() {
    }

    /**
     * 渲染 Windows 风格按钮。
     *
     * @return 描述 Windows 按钮外观的字符串
     */
    @Override
    public String render() {
        return "渲染 Windows 风格按钮：方角、灰底、白色文字";
    }
}
