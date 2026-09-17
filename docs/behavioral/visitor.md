# 访问者模式（Visitor）

## 一、意图
表示一个作用于某对象结构中的各元素的操作。访问者模式使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。它通过"双重分派"在运行时根据元素和访问者的实际类型决定调用哪个方法。

## 二、使用场景
- 需要对一个复杂对象结构（如组合树）执行多种不同的操作，且这些操作互相无关
- 不希望在各元素类中嵌入操作逻辑（保持元素类稳定）
- 元素类型集合相对稳定，但操作种类经常扩展
- 编译器 AST、报告生成、规则校验、序列化等

## 三、结构
```
                     +-----------------+
                     |    Visitor      | (interface)
                     | visit(A) visit(B)|
                     +-----------------+
                       ^       ^
   ConcreteVisitorA ---|       |--- ConcreteVisitorB
                       |
       +--------------+---------------------+
       |              | accept(visitor)      |
   +----------+   +-----------------+
   | Element  |   | ConcreteElementA |  accept(v){v.visit(this);}
   +----------+   +-----------------+
       ^
   ConcreteElementB (similar)
       ^
   ObjectStructure --holds--> elements, accept(v) on each
```

双重分派（double dispatch）：
1. 第一重分派：客户端调用 `element.accept(visitor)`，运行时根据元素的实际类型选择对应的 `accept` 实现
2. 第二重分派：`accept` 内部调用 `visitor.visit(this)`，根据 `this` 的静态类型选择对应的重载 `visit` 方法

## 四、角色说明
- **Visitor（抽象访问者）**：为每一种具体元素声明对应的 visit 重载方法
- **ConcreteVisitor（具体访问者）**：实现每个 visit 重载，封装具体操作
- **Element（抽象元素）**：声明 `accept(Visitor)` 方法
- **ConcreteElement（具体元素）**：实现 `accept`，在其中调用 `visitor.visit(this)`，触发双重分派
- **ObjectStructure（对象结构）**：枚举元素集合，提供给访问者遍历的入口

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/visitor/Element.java` —— 抽象元素
- `src/main/java/com/example/behavioral/visitor/ConcreteElementA.java` —— 元素 A
- `src/main/java/com/example/behavioral/visitor/ConcreteElementB.java` —— 元素 B
- `src/main/java/com/example/behavioral/visitor/Visitor.java` —— 抽象访问者
- `src/main/java/com/example/behavioral/visitor/ConcreteVisitorA.java` —— 访问者 A
- `src/main/java/com/example/behavioral/visitor/ConcreteVisitorB.java` —— 访问者 B
- `src/main/java/com/example/behavioral/visitor/ObjectStructure.java` —— 对象结构
- `src/main/java/com/example/behavioral/visitor/VisitorDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 在不修改元素类的前提下新增操作，符合开闭原则（对扩展开放）
- 把相关操作集中在访问者中，避免分散
- 同一对象结构可被多种访问者遍历，操作可累积
- 双重分派能在运行时根据元素真实类型分发行为

**缺点：**
- 元素类型一旦增加，所有访问者接口与实现都要修改，违反开闭原则
- 破坏元素封装，访问者常需访问元素内部状态
- 元素与访问者之间存在双向依赖

## 七、应用实例
- **JDK**：`java.nio.file.FileVisitor`（`SimpleFileVisitor`）遍历文件树
- **JDK**：`javax.lang.model.element.Element` 与 `ElementVisitor`（注解处理 API）是典型双重分派
- **JDK**：`javax.annotation.processing` 处理器
- **常见**：编译器 AST 节点与访问者、ASM 字节码访问者、规则引擎

## 八、与相关模式对比
- **访问者 vs 策略**：策略封装"单一对象的多种算法"；访问者封装"对一组对象结构的多种操作"
- **访问者 vs 方法重载**：方法重载是静态绑定（编译期分派），无法根据运行时类型选择；访问者通过双重分派实现运行时分派
- **访问者 vs 组合**：组合模式常与访问者配合，对树形结构施加操作

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.visitor.VisitorDemo"
```
