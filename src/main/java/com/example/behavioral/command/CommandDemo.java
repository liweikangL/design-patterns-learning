package com.example.behavioral.command;

/**
 * 命令模式演示入口。
 * 演示命令的入队、批量执行与撤销操作。
 */
public class CommandDemo {

    /**
     * 程序入口：演示命令模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 命令模式演示开始 =====");

        // 创建接收者
        Light light = new Light();

        // 创建命令
        Command on = new LightOnCommand(light);
        Command off = new LightOffCommand(light);

        // 创建调用者并装配命令队列
        RemoteControl remote = new RemoteControl();
        remote.addCommand(on);
        remote.addCommand(off);
        remote.addCommand(on);

        // 批量执行队列中的命令
        remote.executeAll();

        // 撤销最近一次命令（应为开灯，撤销后变关灯）
        remote.undoLast();
        // 再撤销一次（应为关灯，撤销后变开灯）
        remote.undoLast();

        System.out.println("===== 命令模式演示结束 =====");
    }
}
