# 状态模式（State）

## 一、意图
允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。状态模式把状态的判断逻辑封装到一系列状态类中，并将状态切换的决策权交给状态对象自身，从而消除庞大的条件分支。

## 二、使用场景
- 对象的行为随其状态而改变，且状态转换逻辑复杂
- 代码中存在大量与状态相关的 if/else 或 switch 分支
- 希望把状态相关的行为局部化到独立的状态类中
- 状态机、订单/工单流转、TCP 连接状态、游戏角色状态等

## 三、结构
```
   Client
     |
     v
+---------------+   setState()   +----------------+
|   Context     | -------------> |   State        | (abstract)
| (状态上下文)   | <------------- |                |
+---------------+  getState()    +----------------+
     |  delegates handle()             ^
     |                                  | implements
     v                                  |
   +------------------+          +------------------+
   |   StartState     |          |   StopState     |
   |   handle() ->    |  next   |   handle() ->   |
   |   set StopState  |  state  |   set StartState|
   +------------------+          +------------------+
```

状态对象在 handle() 时自行决定下一个状态并写回 Context。

## 四、角色说明
- **Context（上下文）**：维护当前状态对象，将状态相关行为委托给当前状态
- **State（抽象状态）**：声明状态行为接口
- **ConcreteState（具体状态）**：实现具体行为，并在适当时机决定切换到下一个状态

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/state/State.java` —— 抽象状态
- `src/main/java/com/example/behavioral/state/StartState.java` —— 启动状态
- `src/main/java/com/example/behavioral/state/StopState.java` —— 停止状态
- `src/main/java/com/example/behavioral/state/Context.java` —— 状态上下文
- `src/main/java/com/example/behavioral/state/StateDemo.java` —— 演示入口

`StartState.handle()` 会把上下文的下一状态设置为 `StopState`，反之亦然，状态切换完全由状态对象自身决定。

## 六、优缺点
**优点：**
- 将状态相关行为局部化，避免大量条件分支
- 状态转换显式化，新增状态无需修改既有状态类，符合开闭原则
- 状态对象可被复用，结构清晰
- 符合单一职责原则

**缺点：**
- 状态多时类数量膨胀
- 状态对象之间的切换逻辑分散，可能难以追踪整体状态机
- 部分实现需要状态类之间相互引用

## 七、应用实例
- **JDK**：`java.lang.Thread.State` 枚举（NEW/RUNNABLE/BLOCKED…），线程状态机
- **JDK**：`java.util.Iterator` 的遍历状态
- **Spring**：`BeanDefinition`、状态机框架 `spring-statemachine`
- **常见**：订单状态（待支付/已支付/已发货/已完成/已取消）、TCP 连接状态、Akka 有限状态机

## 八、与相关模式对比
- **状态 vs 策略**：策略由客户端选择并可以替换；状态由对象内部根据当前状态自行切换，客户端通常无感知
- **状态 vs 备忘录**：备忘录关注状态保存与恢复；状态关注状态变化时的行为差异
- **状态 vs 责任链**：责任链关注请求由谁处理；状态关注同一对象在不同状态下的不同行为

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.state.StateDemo"
```
