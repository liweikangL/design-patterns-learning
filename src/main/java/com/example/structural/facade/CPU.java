package com.example.structural.facade;

/**
 * 子系统：CPU。
 * <p>
 * 封装 CPU 相关的复杂操作，客户端无需了解其内部细节。
 */
public class CPU {

    /** 启动 CPU。 */
    public void startup() {
        System.out.println("  CPU：上电、加载寄存器、开始执行指令");
    }

    /** 关闭 CPU。 */
    public void shutdown() {
        System.out.println("  CPU：保存上下文、停止时钟、断电");
    }
}
