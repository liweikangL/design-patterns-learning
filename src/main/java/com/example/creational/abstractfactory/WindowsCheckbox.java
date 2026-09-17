package com.example.creational.abstractfactory;

/**
 * Windows 风格复选框（具体产品 B1）。
 *
 * <p>实现 {@link Checkbox} 接口，提供 Windows 主题下复选框的具体外观。</p>
 */
public class WindowsCheckbox implements Checkbox {

    /**
     * 默认构造方法。
     */
    public WindowsCheckbox() {
    }

    /**
     * 渲染 Windows 风格复选框。
     *
     * @return 描述 Windows 复选框外观的字符串
     */
    @Override
    public String render() {
        return "渲染 Windows 风格复选框：方角、白色背景、黑色勾选";
    }
}
