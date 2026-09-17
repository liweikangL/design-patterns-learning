package com.example.behavioral.command;

/**
 * 具体命令：关灯命令。
 * 持有接收者（电灯）的引用，调用接收者完成关灯，撤销时则开灯。
 */
public class LightOffCommand implements Command {

    /** 接收者 */
    private final Light light;

    /**
     * 构造方法，注入接收者。
     *
     * @param light 电灯
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行关灯。
     */
    @Override
    public void execute() {
        light.turnOff();
    }

    /**
     * 撤销关灯（即开灯）。
     */
    @Override
    public void undo() {
        light.turnOn();
    }
}
