package com.example.structural.facade;

/**
 * 子系统：内存（Memory）。
 * <p>
 * 封装内存的自检、加载与清理操作。
 */
public class Memory {

    /** 内存启动：自检并加载。 */
    public void startup() {
        System.out.println("  Memory：内存自检通过，加载引导扇区");
    }

    /** 内存关闭：清理并断电。 */
    public void shutdown() {
        System.out.println("  Memory：清理内存数据、断电");
    }
}
