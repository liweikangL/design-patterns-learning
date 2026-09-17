package com.example.structural.decorator;

/**
 * 抽象构件（Component）。
 * <p>
 * 定义构件与装饰器共有的接口，具体构件和抽象装饰器都实现该接口，
 * 使装饰器可以透明地替换被装饰对象。
 */
public interface Component {

    /**
     * 业务方法：返回构件所提供功能的描述。
     *
     * @return 功能描述
     */
    String operation();
}
