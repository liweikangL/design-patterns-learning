# 享元模式（Flyweight）

## 一、意图
运用共享技术有效地支持大量细粒度对象的复用，降低内存占用。享元模式将对象状态分为可共享的"内部状态"与不可共享的"外部状态"，内部状态由享元对象保存并被多个客户端共享，外部状态由客户端在调用时传入。

## 二、使用场景
- 系统中存在大量相似对象，造成内存浪费。
- 对象的大部分状态可以外部化（作为参数传入）。
- 需要缓冲池的场景：如线程池、连接池、字符串常量池。
- 文本编辑器中的字符、棋类游戏中的棋子、网格中的树木等。

## 三、结构
```
        Client
          │ uses
          ▼
   FlyweightFactory ── has-a ── Flyweight（interface）
          │                          ▲
        pool(Map)                    │
                                 ConcreteFlyweight  UnsharedFlyweight
                                  内部状态(intrinsic)  非共享、独有
   外部状态(extrinsic) 由 Client 在 operation(state) 时传入
```

## 四、角色说明
- **Flyweight 享元接口**：定义业务方法，接受外部状态参数。
- **ConcreteFlyweight 具体享元**：保存内部状态，可被共享。
- **UnsharedFlyweight 非共享享元**：不被共享的享元，常作为复合或个性化对象。
- **FlyweightFactory 享元工厂**：维护享元池，按 key 创建/复用享元。
- **Client 客户端**：维护外部状态并使用享元对象。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/flyweight/`，以围棋棋盘为例：
- `Flyweight.java`：享元接口，`operation(extrinsicState)`。
- `ConcreteFlyweight.java`：棋子享元，内部状态 = 颜色。
- `UnsharedFlyweight.java`：棋盘标记，非共享。
- `FlyweightFactory.java`：享元工厂，按颜色缓存棋子。
- `FlyweightDemo.java`：演示多步落子后池中对象数仍为 2。

## 六、优缺点
**优点：**
- 大幅减少相似对象数量，节省内存。
- 把状态分离到外部，使享元可在不同上下文复用。
- 工厂集中管理，便于统计与回收。

**缺点：**
- 增加系统复杂性，需要区分内部/外部状态。
- 外部状态由客户端管理，可能让调用代码变复杂。
- 节省内存以增加查找/管理时间为代价。

## 七、应用实例
- **JDK**：`Integer.valueOf(int)`、`String` 字符串常量池（`-XX:StringTableSize`）是典型的享元缓存。
- **JDK**：`Boolean.TRUE/FALSE`、`Character.of(int)`（部分 ASCII 字符缓存）共享实例。
- **JDK**：`ThreadPoolExecutor` 中的 Worker 线程复用，连接池中的 Connection 复用，思想类似。
- **Netty**：`ByteBufAllocator` 通过池化复用 ByteBuf 实现高效内存利用。

## 八、与相关模式对比
- **Flyweight vs Singleton**：Singleton 保证全局唯一实例；Flyweight 允许多个实例，但按内部状态共享。
- **Flyweight vs Composite**：常结合使用，复合享元由多个具体享元组成，仍可共享。
- **Flyweight vs Object Pool**：享元关注"状态共享"；对象池关注"对象复用"，池中对象状态会变化。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.flyweight.FlyweightDemo"
```
