package com.example.creational.abstractfactory;

/**
 * 抽象工厂模式演示入口。
 *
 * <p>演示如何通过不同主题工厂创建一族相互协调的 UI 组件，
 * 客户端只依赖 {@link GUIFactory} 抽象与 {@link Button}/{@link Checkbox} 接口。</p>
 */
public class AbstractFactoryDemo {

    /**
     * 程序入口，演示抽象工厂模式的典型用法。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("====== 抽象工厂模式演示开始 ======");

        // 1. 使用 Windows 主题工厂创建 Windows 风格组件族
        System.out.println("\n[1] 使用 WindowsFactory 创建组件：");
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        System.out.println(windowsButton.render());
        System.out.println(windowsCheckbox.render());

        // 2. 使用 Mac 主题工厂创建 Mac 风格组件族
        System.out.println("\n[2] 使用 MacFactory 创建组件：");
        GUIFactory macFactory = new MacFactory();
        Button macButton = macFactory.createButton();
        Checkbox macCheckbox = macFactory.createCheckbox();
        System.out.println(macButton.render());
        System.out.println(macCheckbox.render());

        System.out.println("\n抽象工厂保证同一工厂返回的产品属于同一主题/产品族，");
        System.out.println("新增产品族（如 Linux 风格）只需新增 LinuxFactory 与对应产品，无需改动既有代码。");
        System.out.println("====== 抽象工厂模式演示结束 ======");
    }
}
