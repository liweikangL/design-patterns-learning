# 装饰器模式（Decorator）

## 一、意图
动态地给一个对象添加额外职责，相比继承更加灵活。装饰器模式通过包装（组合）原对象，在不修改原对象、不改变接口的前提下叠加新行为，且可按需任意组合多层装饰。

## 二、使用场景
- 需要动态、透明地给对象添加职责，且不希望使用子类继承。
- 职责可以叠加且顺序可变，例如多次包装。
- 当继承方式会让子类数量爆炸（功能笛卡尔积）时。

## 三、结构
```
        Component（interface）
            ▲ operation()
   ┌────────┴────────┐
   │                 │
ConcreteComponent   Decorator（abstract）
                     │  has-a Component
                     ▲
                     │
        ┌────────────┴────────────┐
ConcreteDecoratorA            ConcreteDecoratorB
 addedState                    addedBehavior
 operation()  += state        operation() += behavior
```
Decorator 与 ConcreteComponent 实现同一接口，故 ConcreteDecorator 也能再被装饰。

## 四、角色说明
- **Component 抽象构件**：定义构件和装饰器的统一接口。
- **ConcreteComponent 具体构件**：被装饰的原始对象，提供基础功能。
- **Decorator 抽象装饰器**：实现 Component，持有 Component 引用，默认委派调用。
- **ConcreteDecorator 具体装饰器**：在委派基础上叠加状态或行为。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/decorator/`：
- `Component.java`：抽象构件接口。
- `ConcreteComponent.java`：基础功能实现。
- `Decorator.java`：抽象装饰器，组合持有构件。
- `ConcreteDecoratorA.java`：叠加"状态 A"。
- `ConcreteDecoratorB.java`：叠加"行为 B"。
- `DecoratorDemo.java`：演示多层装饰与顺序变化。

## 六、优缺点
**优点：**
- 比继承更灵活，可在运行时叠加职责，符合开闭原则。
- 装饰器与构件接口一致，客户端无感知。
- 多个装饰职责可拆分为小类，按需组合，避免类爆炸。

**缺点：**
- 多层装饰会产生较多小对象，增加理解成本。
- 调用栈随装饰层数加深，调试困难。
- 同类型装饰器顺序敏感，错误顺序可能产生非预期结果。

## 七、应用实例
- **JDK IO 流**：`InputStream` 为抽象构件，`FileInputStream` 为具体构件，`BufferedInputStream`/`DataInputStream` 为装饰器，层层包装。
- **JDK Collections**：`Collections.synchronizedList()`、`unmodifiableList()` 用装饰器给 List 添加同步/只读能力。
- **Spring**：事务管理、缓存等通过代理/装饰增强 Bean 行为。

## 八、与相关模式对比
- **Decorator vs Proxy**：Decorator 关注"叠加职责"，且装饰者与构件接口一致；Proxy 关注"访问控制"，代理不一定增强功能。
- **Decorator vs Adapter**：Decorator 不改接口、只加职责；Adapter 改接口、不加功能。
- **Decorator vs Composite**：Decorator 是单链包装；Composite 是树形聚合。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.decorator.DecoratorDemo"
```
