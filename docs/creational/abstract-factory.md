# 抽象工厂（Abstract Factory）

## 一、意图

提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。抽象工厂模式关注"产品族"——同一工厂返回的所有产品属于同一主题/风格，相互之间天然协调。客户端只需选择一个具体工厂，即可获得一整套互相兼容的产品，而不需要分别挑选每一个组件。

## 二、使用场景

- 系统需要独立于其产品的创建、组合和表示方式时。
- 系统需要配置成具有多个产品族之一，且未来可能整体切换（如 Windows/Mac/Linux 主题切换）。
- 需要强调一族相关产品联合使用的语义，避免跨族混搭造成不协调。
- 希望在切换产品族时只改一个工厂，而无需逐个修改调用点。

## 三、结构

```
                ┌─────────────────────┐
                │   <<interface>>    │
                │     GUIFactory      │  (抽象工厂)
                ├─────────────────────┤
                │ + createButton()    │ ──┐
                │ + createCheckbox()  │ ──┼── 创建一族产品
                └─────────────────────┘  │
                          △ △             │
           ┌──────────────┘ └──────────┐  │
           │                           │  │
   ┌──────────────┐            ┌──────────────┐
   │WindowsFactory│            │  MacFactory  │
   └──────────────┘            └──────────────┘
           │                           │
        creates                     creates
   ┌─────┴───────┐             ┌─────┴───────┐
   │             │             │             │
WindowsButton  WindowsCheckbox  MacButton    MacCheckbox
   (产品族 A)                  (产品族 B)
```

## 四、角色说明

- **AbstractFactory（抽象工厂）**：声明一族创建相关产品的工厂方法。
- **ConcreteFactory（具体工厂）**：实现工厂方法，返回属于同一产品族的具体产品。
- **AbstractProduct（抽象产品 A/B）**：声明每种产品维度的统一行为，如 `Button`、`Checkbox`。
- **ConcreteProduct（具体产品）**：实现抽象产品，依附于某个具体工厂的产品族。
- **Client（客户端）**：仅依赖抽象工厂与抽象产品，与具体类型解耦。

## 五、代码示例

本仓库在 `src/main/java/com/example/creational/abstractfactory/` 下实现：

- `Button.java` / `Checkbox.java`：两个抽象产品维度。
- `WindowsButton.java` / `WindowsCheckbox.java`：Windows 主题产品族。
- `MacButton.java` / `MacCheckbox.java`：Mac 主题产品族。
- `GUIFactory.java`：抽象工厂接口。
- `WindowsFactory.java` / `MacFactory.java`：两个具体工厂。
- `AbstractFactoryDemo.java`：演示入口。

## 六、优缺点

**优点：**

- 同一工厂返回的产品族天然协调，避免跨族混搭出错。
- 切换产品族只需替换工厂实例，调用点不变，符合开闭原则（针对产品族切换）。
- 客户端只依赖抽象，便于在不同主题/平台间切换。

**缺点：**

- 新增一种产品维度（如新增 `TextField`）需要修改所有抽象与具体工厂，违反开闭原则。
- 类数量较多，每个产品族+每种产品维度都需要一组类。
- 对"产品族频繁切换"友好，对"产品维度频繁扩展"不友好。

## 七、应用实例

- **JDK**：`javax.xml.parsers.DocumentBuilderFactory` / `SAXParserFactory` 是抽象工厂，可返回不同 XML 解析实现。
- **Spring**：`BeanFactory` 视为抽象工厂，不同实现（`DefaultListableBeanFactory`、`StaticListableBeanFactory`）返回不同 bean 族。
- **Java AWT / Swing**：`Toolkit` 抽象工厂按平台返回不同本地 Peer 组件族（按钮、窗口等）。
- **跨平台 UI 框架**：IntelliJ 平台的主题工厂、JavaFX 的 `Toolkit` 均体现"一族相关产品"的语义。

## 八、与相关模式对比

| 模式 | 关键差异 |
|------|----------|
| 抽象工厂 | 创建一族相关产品，强调"多产品维度 + 一致的产品族"。 |
| 工厂方法 | 创建一种产品，每个工厂对应一个产品维度；抽象工厂可视为多个工厂方法的组合。 |
| 生成器（Builder） | 关注按步骤构造一个复杂对象；抽象工厂关注一次性返回一族产品。 |
| 原型 | 用克隆方式生成；抽象工厂用 new 方式生成，适合产品初始化参数较多的情况。 |

## 九、运行示例

```bash
mvn -q exec:java -Dexec.mainClass="com.example.creational.abstractfactory.AbstractFactoryDemo"
```
