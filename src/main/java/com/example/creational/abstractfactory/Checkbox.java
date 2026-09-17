package com.example.creational.abstractfactory;

/**
 * 抽象产品 B：复选框。
 *
 * <p>定义复选框这一产品维度的统一行为，由不同主题工厂提供具体实现。</p>
 */
public interface Checkbox {

    /**
     * 渲染并显示复选框。
     *
     * @return 描述复选框外观与行为的字符串
     */
    String render();
}
