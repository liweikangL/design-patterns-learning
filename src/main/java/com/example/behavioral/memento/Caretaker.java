package com.example.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 管理者（Caretaker）。
 * 负责保存发起人创建的备忘录，不能修改备忘录内容，仅提供存取功能。
 * 本示例使用栈结构保存多份备忘录，以支持多次回滚。
 */
public class Caretaker {

    /** 备忘录栈，后进先出便于多次撤销 */
    private final Deque<Memento> history = new ArrayDeque<>();

    /**
     * 保存一份备忘录。
     *
     * @param memento 备忘录
     */
    public void save(Memento memento) {
        history.push(memento);
    }

    /**
     * 取出最近一次保存的备忘录。
     *
     * @return 最近一次的备忘录；若栈为空则返回 null
     */
    public Memento undo() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }
}
