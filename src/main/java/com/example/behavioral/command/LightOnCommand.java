package com.example.behavioral.command;

/**
 * 具体命令：开灯命令。
 * 持有接收者（电灯）的引用，调用接收者完成开灯，撤销时则关灯。
 */
public class LightOnCommand implements Command {

    /** 接收者 */
    private final Light light;

    /**
     * 构造方法，注入接收者。
     *
     * @param light 电灯
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行开灯。
     */
    @Override
    public void execute() {
        light.turnOn();
    }

    /**
     * 撤销开灯（即关灯）。
     */
    @Override
    public void undo() {
        light.turnOff();
    }
}
