package com.example.creational.abstractfactory;

/**
 * 抽象产品 A：按钮。
 *
 * <p>定义按钮这一产品维度的统一行为，由不同主题工厂提供具体实现。</p>
 */
public interface Button {

    /**
     * 渲染并显示按钮。
     *
     * @return 描述按钮外观与行为的字符串
     */
    String render();
}
