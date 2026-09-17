package com.example.behavioral.memento;

/**
 * 备忘录模式演示入口。
 * 演示发起人通过管理者保存多份状态快照，并按需回滚到历史状态。
 */
public class MementoDemo {

    /**
     * 程序入口：演示备忘录模式。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("===== 备忘录模式演示开始 =====");

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 第 1 个状态，保存快照
        originator.setState("状态 #1：编辑文档第一段");
        caretaker.save(originator.createMemento());
        System.out.println("当前状态：" + originator.getState());

        // 第 2 个状态，保存快照
        originator.setState("状态 #2：编辑文档第二段");
        caretaker.save(originator.createMemento());
        System.out.println("当前状态：" + originator.getState());

        // 第 3 个状态，不保存
        originator.setState("状态 #3：误删段落");
        System.out.println("当前状态：" + originator.getState());

        // 回滚一次
        Memento last = caretaker.undo();
        if (last != null) {
            originator.restoreFromMemento(last);
            System.out.println("撤销后状态：" + originator.getState());
        }

        // 再回滚一次
        last = caretaker.undo();
        if (last != null) {
            originator.restoreFromMemento(last);
            System.out.println("再次撤销后状态：" + originator.getState());
        }

        System.out.println("===== 备忘录模式演示结束 =====");
    }
}
