package com.example.structural.facade;

/**
 * 外观类（Facade）。
 * <p>
 * 聚合 {@link CPU}、{@link Memory}、{@link HardDrive} 三个子系统，
 * 对外暴露简化的 {@link #start()} / {@link #stop()} 接口，
 * 隐藏子系统启动/关闭的复杂调用顺序。
 */
public class Computer {

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    /**
     * 构造外观对象，组装各子系统。
     */
    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    /**
     * 一键启动计算机：按正确顺序启动各子系统。
     */
    public void start() {
        System.out.println(">>> 计算机开始启动（外观统一调用）：");
        cpu.startup();
        memory.startup();
        hardDrive.startup();
        System.out.println(">>> 计算机启动完成");
    }

    /**
     * 一键关闭计算机：按正确顺序关闭各子系统。
     */
    public void stop() {
        System.out.println(">>> 计算机开始关机（外观统一调用）：");
        hardDrive.shutdown();
        memory.shutdown();
        cpu.shutdown();
        System.out.println(">>> 计算机已关机");
    }
}
