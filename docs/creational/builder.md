# 建造者模式（Builder）

## 一、意图

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。建造者模式关注"分步骤构建复杂对象"——把一个具有大量可选字段、复杂初始化逻辑的对象拆成多步装配，避免出现"长参数列表构造方法"或"setter 调用顺序混乱"等可读性问题。

## 二、使用场景

- 对象属性很多，且大部分可选，使用构造方法或 setter 调用易出错、可读性差。
- 同一构建顺序可以产出不同表示（如不同配置的报表、不同主题的文档）。
- 希望最终对象不可变（一次性装配完成后不再变化），同时构建过程灵活。
- 需要为同一类产品提供多种"标准预设"配置（如 Director 提供 buildStandard / buildPromotion）。

## 三、结构

```
        ┌────────────────────────┐                  ┌──────────────┐
        │   <<interface>>        │                  │   Director   │
        │       Builder<T>       │                  ├──────────────┤
        ├────────────────────────┤  uses            │ - builder    │
        │ + reset(): Builder<T>  │◄─────────────────│ + buildStandard(...)
        │ + buildPartA(...)      │                  │ + buildPromotion(...)
        │ + buildPartB(...)      │                  └──────────────┘
        │ + buildPartC(...)      │                          │ constructs
        │ + build(): T           │                          │
        └────────────────────────┘                          │
                    △                                       ▼
                    │                                  ┌──────────────┐
                    │                                  │   Product    │  ← 最终产品
            ┌───────┴───────┐                          └──────────────┘
            │               │
    ┌──────────────┐  ┌──────────────┐
    │ConcreteBuilder│  │  ...其他建造者 │
    └──────────────┘  └──────────────┘
```

## 四、角色说明

- **Builder（抽象建造者）**：声明构建各部分的方法接口，通常含 `reset`、`buildPartX`、`build` 等。
- **ConcreteBuilder（具体建造者）**：实现接口，提供各步骤的具体逻辑，并维护最终产品的装配状态。
- **Director（指挥者）**：封装常用构建顺序，调用建造者接口完成装配，便于复用预设配置。
- **Product（产品）**：最终被装配出的复杂对象，通常字段较多且装配后不可变。
- **Client（客户端）**：可借助 Director 获得预设产品，也可直接链式调用建造者自由装配。

## 五、代码示例

本仓库在 `src/main/java/com/example/creational/builder/` 下实现：

- `Product.java`：复杂产品类，内嵌静态 `Builder`，字段不可变，提供链式 setter。
- `Builder.java`：抽象建造者接口（泛型 `<T>`，重置 / buildPartA / buildPartB / buildPartC / build）。
- `ConcreteBuilder.java`：具体建造者，基于 `Product.Builder` 实现接口，同时暴露 `chain()` 直接链式调用。
- `Director.java`：指挥者，封装 `buildStandard` / `buildPromotion` 两种顺序。
- `BuilderDemo.java`：演示入口。

## 六、优缺点

**优点：**

- 复杂对象的分步构建清晰可读，链式调用体验好。
- 同一构建顺序可产出不同表示，新增表示只需新增建造者。
- 装配完成后产品可设为不可变，线程安全友好。
- Director 可封装常用预设，减少客户端重复代码。

**缺点：**

- 类数量与样板代码增加，对简单对象属于过度设计。
- 产品内部结构变化时，所有建造者可能都需要同步修改。
- 链式调用易掩盖中间出错状态，需要保证 build 前字段有效。

## 七、应用实例

- **JDK**：`StringBuilder` / `StringBuffer` 即典型建造者，逐步 append 最终 toString() 输出字符串。
- **JDK**：`java.lang.StringBuilder` 的兄弟 `DocumentBuilder`（`javax.xml.parsers`）按步骤构建 DOM 文档。
- **Spring**：`BeanDefinitionBuilder` 用于链式构建 Bean 定义。
- **MyBatis**：`SqlSessionFactoryBuilder` 通过链式读取配置构建 `SqlSessionFactory`。
- **OkHttp**：`Request.Builder` / `MultipartBody.Builder` 等大量使用链式建造者。

## 八、与相关模式对比

| 模式 | 关键差异 |
|------|----------|
| 建造者 | 关注"分步构建一个复杂对象"，最终装配出一个产品。 |
| 抽象工厂 | 关注"一次性返回一族相关产品"，每个工厂方法一步到位。 |
| 工厂方法 | 一步创建一种产品；建造者可看作"多步工厂"。 |
| 原型 | 通过克隆复制对象；建造者通过 new + 链式装配。 |

## 九、运行示例

```bash
mvn -q exec:java -Dexec.mainClass="com.example.creational.builder.BuilderDemo"
```
