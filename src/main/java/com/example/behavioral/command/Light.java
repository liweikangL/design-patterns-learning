package com.example.behavioral.command;

/**
 * 接收者（Receiver）—— 电灯。
 * 真正执行开灯/关灯业务逻辑的对象。
 */
public class Light {

    /** 当前灯的状态：true 表示亮，false 表示灭 */
    private boolean on = false;

    /**
     * 开灯。
     */
    public void turnOn() {
        on = true;
        System.out.println("灯被打开（亮）");
    }

    /**
     * 关灯。
     */
    public void turnOff() {
        on = false;
        System.out.println("灯被关闭（灭）");
    }

    /**
     * 查询灯当前状态。
     *
     * @return true 表示灯亮
     */
    public boolean isOn() {
        return on;
    }
}
