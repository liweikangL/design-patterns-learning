package com.example.behavioral.command;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 调用者（Invoker）—— 遥控器。
 * 维护一个命令队列，可以批量执行命令，并使用栈结构记录已执行命令以支持撤销。
 */
public class RemoteControl {

    /** 命令队列，等待被批量执行 */
    private final List<Command> commandQueue = new ArrayList<>();

    /** 已执行命令的栈，用于撤销 */
    private final Deque<Command> executedStack = new ArrayDeque<>();

    /**
     * 添加命令到队列。
     *
     * @param command 命令
     */
    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    /**
     * 批量执行队列中的所有命令，并将其压入已执行栈以便后续撤销。
     */
    public void executeAll() {
        System.out.println("--- 批量执行命令队列 ---");
        for (Command command : commandQueue) {
            command.execute();
            executedStack.push(command);
        }
        commandQueue.clear();
    }

    /**
     * 撤销最近一次执行的命令。
     */
    public void undoLast() {
        if (executedStack.isEmpty()) {
            System.out.println("没有可撤销的命令");
            return;
        }
        Command last = executedStack.pop();
        System.out.println("--- 撤销最近一次命令 ---");
        last.undo();
    }
}
