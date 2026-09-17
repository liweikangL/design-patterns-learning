# 工厂方法（Factory Method）

## 一、意图

定义一个用于创建对象的接口，但让子类决定实例化哪一个具体类。工厂方法使一个类的实例化延迟到其子类，从而实现"对象创建"与"对象使用"的解耦，并符合开闭原则——新增产品类型时只需新增对应工厂，而不必修改既有客户端代码。

## 二、使用场景

- 调用方不关心、也不应关心对象的具体创建过程与具体类型时。
- 希望在系统中预留扩展点：未来可能新增产品类型，希望以"加类"而非"改代码"的方式扩展。
- 不同运行环境/配置下需要创建不同实现，但调用方期望统一接口。
- 想把对象创建逻辑集中管理、便于测试替身（Mock）替换。

## 三、结构

```
       ┌─────────────────┐                  ┌──────────────┐
       │   <<interface>> │                  │ <<interface>>│
       │     Product     │                  │    Factory   │  (抽象类)
       ├─────────────────┤                  ├──────────────┤
       │ + use(): String  │ ───────────┐   │ + createProduct(): Product │
       └─────────────────┘            │   │ + doSomething(): String     │
                ▲ ▲                  creates └──────────────┘
                │ │                              △ △
       ┌────────┘ └──────┐                       │ │
       │                 │            creates     │ │
┌──────────────┐  ┌──────────────┐      ┌──────────────┐  ┌──────────────┐
│ConcreteProductA│ │ConcreteProductB│     │ConcreteFactoryA│ │ConcreteFactoryB│
└──────────────┘  └──────────────┘      └──────────────┘  └──────────────┘
```

## 四、角色说明

- **Product（产品接口）**：声明所有具体产品的统一行为，客户端依赖它而非具体类。
- **ConcreteProduct（具体产品）**：实现 Product 接口，提供具体业务逻辑。
- **Factory（工厂抽象）**：声明工厂方法 `createProduct()`，可附带模板方法封装通用流程。
- **ConcreteFactory（具体工厂）**：实现工厂方法，决定创建哪种具体产品。
- **Client（客户端）**：依赖 Factory 抽象与 Product 接口，与具体类解耦。

## 五、代码示例

本仓库在 `src/main/java/com/example/creational/factory/` 下实现：

- `Product.java`：产品接口。
- `ConcreteProductA.java` / `ConcreteProductB.java`：两种具体产品。
- `Factory.java`：抽象工厂，声明工厂方法并提供模板方法 `doSomething()`。
- `ConcreteFactoryA.java` / `ConcreteFactoryB.java`：两个具体工厂。
- `FactoryDemo.java`：演示入口。

## 六、优缺点

**优点：**

- 客户端只依赖抽象，新增产品无需改动既有代码，符合开闭原则。
- 创建逻辑集中在工厂，避免散落在调用点，便于维护与替换实现。
- 工厂可以结合模板方法封装"创建→使用"的标准流程。

**缺点：**

- 每新增一种产品就需要新增一个工厂类，类数量增加。
- 抽象层多一层，对简单场景可能过度设计。
- 客户端仍需选择使用哪个具体工厂。

## 七、应用实例

- **JDK**：`java.util.Collection#iterator()` 即工厂方法，不同集合（`ArrayList`、`LinkedList`）返回各自的 `Iterator` 实现。
- **Spring**：`BeanFactory` / `FactoryBean` 是工厂方法的代表，由容器根据配置创建 Bean。
- **SLF4J / Logback**：`ILoggerFactory` 通过工厂方法返回不同 `Logger` 实现。
- **JDBC**：`DriverManager.getConnection()` 是简化版工厂，根据 URL 选择具体驱动返回 `Connection`。

## 八、与相关模式对比

| 模式 | 关键差异 |
|------|----------|
| 工厂方法 | 关注"创建一种产品"，通过子类决定具体类型；产品结构是 1:N 的扩展。 |
| 抽象工厂 | 关注"创建一族相关产品"，每个工厂方法对应一种产品维度；多个工厂方法协同。 |
| 简单工厂（静态工厂） | 工厂方法模式去掉抽象层、用 switch 创建对象；简单但不符开闭原则。 |
| 模板方法 | 工厂方法常与模板方法结合（如 `Factory#doSomething`），但前者关注"创建"，后者关注"流程骨架"。 |

## 九、运行示例

```bash
mvn -q exec:java -Dexec.mainClass="com.example.creational.factory.FactoryDemo"
```
