# 设计模式学习仓库 (Design Patterns Learning)

> 本仓库系统整理了 GoF（Gang of Four）23 种经典设计模式，并补充少量常用模式。
> 每种模式均包含**详细中文说明文档**与**可直接运行的 Java 代码示例**。

## 项目结构

```
design-patterns-learning/
├── README.md                     # 项目总览（本文件）
├── pom.xml                       # Maven 构建配置
├── docs/                         # 设计模式说明文档
│   ├── creational/              #   创建型模式
│   ├── structural/              #   结构型模式
│   └── behavioral/              #   行为型模式
└── src/main/java/com/example/  # Java 代码示例
    ├── creational/
    ├── structural/
    └── behavioral/
```

## 环境要求

- JDK 8 及以上
- Maven 3.5 及以上（用于编译/打包；如不使用 Maven，可直接编译 `src/main/java` 下的源文件）

## 快速开始

```bash
# 编译整个项目
mvn clean compile

# 运行某个模式的演示类（以单例模式为例）
mvn -q exec:java -Dexec.mainClass="com.example.creational.singleton.SingletonDemo"
```

> 每个模式目录下都有 `*Demo.java` 入口类，可以直接运行查看效果。

## 设计模式总览

### 一、创建型模式（Creational Patterns）

关注对象创建过程，将对象创建与使用解耦。

| 模式 | 中文名 | 文档 | 示例入口 |
|------|--------|------|----------|
| Singleton | 单例模式 | [docs](docs/creational/singleton.md) | `creational.singleton.SingletonDemo` |
| Factory Method | 工厂方法 | [docs](docs/creational/factory-method.md) | `creational.factory.FactoryDemo` |
| Abstract Factory | 抽象工厂 | [docs](docs/creational/abstract-factory.md) | `creational.abstractfactory.AbstractFactoryDemo` |
| Builder | 建造者模式 | [docs](docs/creational/builder.md) | `creational.builder.BuilderDemo` |
| Prototype | 原型模式 | [docs](docs/creational/prototype.md) | `creational.prototype.PrototypeDemo` |

### 二、结构型模式（Structural Patterns）

关注类与对象的组合，解决接口与实现之间的关系。

| 模式 | 中文名 | 文档 | 示例入口 |
|------|--------|------|----------|
| Adapter | 适配器模式 | [docs](docs/structural/adapter.md) | `structural.adapter.AdapterDemo` |
| Bridge | 桥接模式 | [docs](docs/structural/bridge.md) | `structural.bridge.BridgeDemo` |
| Composite | 组合模式 | [docs](docs/structural/composite.md) | `structural.composite.CompositeDemo` |
| Decorator | 装饰器模式 | [docs](docs/structural/decorator.md) | `structural.decorator.DecoratorDemo` |
| Facade | 外观模式 | [docs](docs/structural/facade.md) | `structural.facade.FacadeDemo` |
| Flyweight | 享元模式 | [docs](docs/structural/flyweight.md) | `structural.flyweight.FlyweightDemo` |
| Proxy | 代理模式 | [docs](docs/structural/proxy.md) | `structural.proxy.ProxyDemo` |

### 三、行为型模式（Behavioral Patterns）

关注对象之间的通信与职责分配。

| 模式 | 中文名 | 文档 | 示例入口 |
|------|--------|------|----------|
| Chain of Responsibility | 责任链模式 | [docs](docs/behavioral/chain-of-responsibility.md) | `behavioral.chain.ChainDemo` |
| Command | 命令模式 | [docs](docs/behavioral/command.md) | `behavioral.command.CommandDemo` |
| Iterator | 迭代器模式 | [docs](docs/behavioral/iterator.md) | `behavioral.iterator.IteratorDemo` |
| Mediator | 中介者模式 | [docs](docs/behavioral/mediator.md) | `behavioral.mediator.MediatorDemo` |
| Memento | 备忘录模式 | [docs](docs/behavioral/memento.md) | `behavioral.memento.MementoDemo` |
| Observer | 观察者模式 | [docs](docs/behavioral/observer.md) | `behavioral.observer.ObserverDemo` |
| State | 状态模式 | [docs](docs/behavioral/state.md) | `behavioral.state.StateDemo` |
| Strategy | 策略模式 | [docs](docs/behavioral/strategy.md) | `behavioral.strategy.StrategyDemo` |
| Template Method | 模板方法 | [docs](docs/behavioral/template-method.md) | `behavioral.template.TemplateDemo` |
| Visitor | 访问者模式 | [docs](docs/behavioral/visitor.md) | `behavioral.visitor.VisitorDemo` |

> 说明：GoF 中的 Interpreter（解释器模式）应用场景较窄，本仓库暂未收录。

## 学习建议

1. **先看创建型**：理解对象如何被构造，再进入结构型和行为型。
2. **每个模式先读文档**：理解意图、结构、优缺点后再看代码。
3. **运行 Demo 类**：观察输出，结合源码加深印象。
4. **对比相似模式**：如 Strategy vs State、Factory Method vs Abstract Factory、Proxy vs Decorator。
5. **联系实际框架**：在 Spring、JDK 中找到模式真实使用案例（如 Spring AOP = 代理，BeanFactory = 工厂，Collections.sort = 策略）。

## 设计模式速记口诀

> **创建型**（5）：单工抽建原
> **结构型**（7）：适桥组装外享代
> **行为型**（11）：责命迭中介备观状策模访

## 许可证

本仓库仅用于学习交流，可自由复制与修改。
