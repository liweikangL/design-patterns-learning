package com.example.creational.prototype;

/**
 * 原型模式演示入口。
 *
 * <p>通过 {@link ConcretePrototypeA} 与 {@link ConcretePrototypeB}
 * 对比浅拷贝与深拷贝在引用类型字段上的差异。</p>
 */
public class PrototypeDemo {

    /**
     * 程序入口，演示原型模式的典型用法。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("====== 原型模式演示开始 ======");

        // 1. 浅拷贝演示：ConcretePrototypeA 使用继承自父类的默认浅拷贝
        System.out.println("\n[1] 浅拷贝演示（ConcretePrototypeA）：");
        ConcretePrototypeA originalA = new ConcretePrototypeA("原型A");
        originalA.addTag("标签1");
        originalA.addTag("标签2");
        ConcretePrototypeA clonedA = (ConcretePrototypeA) originalA.clone();
        System.out.println("原对象：" + originalA.describe());
        System.out.println("克隆对象：" + clonedA.describe());
        System.out.println("原对象与克隆对象是否同一引用：" + (originalA == clonedA));
        // 修改克隆对象的 tags，原对象也会受影响（浅拷贝共享引用）
        clonedA.getTags().add("标签3");
        System.out.println("向克隆对象添加『标签3』后：");
        System.out.println("  原对象 tags：" + originalA.getTags());
        System.out.println("  克隆对象 tags：" + clonedA.getTags());
        System.out.println("→ 浅拷贝共享引用类型字段，修改会相互影响");

        // 2. 深拷贝演示：ConcretePrototypeB 重写 clone 实现深拷贝
        System.out.println("\n[2] 深拷贝演示（ConcretePrototypeB）：");
        ConcretePrototypeB originalB = new ConcretePrototypeB("原型B");
        originalB.addTag("标签X");
        originalB.addTag("标签Y");
        ConcretePrototypeB clonedB = (ConcretePrototypeB) originalB.clone();
        System.out.println("原对象：" + originalB.describe());
        System.out.println("克隆对象：" + clonedB.describe());
        // 修改克隆对象的 tags，原对象不受影响（深拷贝独立复制）
        clonedB.getTags().add("标签Z");
        System.out.println("向克隆对象添加『标签Z』后：");
        System.out.println("  原对象 tags：" + originalB.getTags());
        System.out.println("  克隆对象 tags：" + clonedB.getTags());
        System.out.println("→ 深拷贝独立复制引用类型字段，修改互不影响");

        System.out.println("\n原型模式通过克隆生成新对象，避免重复初始化的昂贵开销，");
        System.out.println("实现时需注意浅拷贝与深拷贝的取舍。");
        System.out.println("====== 原型模式演示结束 ======");
    }
}
