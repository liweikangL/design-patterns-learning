package com.example.behavioral.command;

/**
 * 命令接口（Command）。
 * 声明执行与撤销操作的方法，所有具体命令必须实现该接口。
 */
public interface Command {

    /**
     * 执行命令。
     */
    void execute();

    /**
     * 撤销命令（恢复到执行前的状态）。
     */
    void undo();
}
