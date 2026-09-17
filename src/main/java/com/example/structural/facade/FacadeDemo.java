package com.example.structural.facade;

/**
 * 外观模式演示入口。
 * <p>
 * 演示通过 Computer 外观一键启动/关闭，避免直接与多个子系统交互。
 */
public class FacadeDemo {

    /**
     * 程序入口，演示外观模式的典型用法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("===== 外观模式演示 =====");

        Computer computer = new Computer();

        // 一键启动
        System.out.println("\n【1】一键启动：");
        computer.start();

        // 一键关闭
        System.out.println("\n【2】一键关闭：");
        computer.stop();

        System.out.println("\n客户端只与 Computer 外观交互，无需关心 CPU/Memory/HardDrive 的启动顺序。");
    }
}
