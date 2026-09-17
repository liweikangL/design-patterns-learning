package com.example.structural.facade;

/**
 * 子系统：硬盘（HardDrive）。
 * <p>
 * 封装硬盘的读写、寻址等复杂操作。
 */
public class HardDrive {

    /** 硬盘启动：上电、磁头归位。 */
    public void startup() {
        System.out.println("  HardDrive：硬盘上电、磁头归位、就绪");
    }

    /** 硬盘关闭：磁头回停区、停转。 */
    public void shutdown() {
        System.out.println("  HardDrive：磁头回停区、主轴停转、断电");
    }
}
