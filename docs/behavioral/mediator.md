# 中介者模式（Mediator）

## 一、意图
用一个中介对象来封装一系列对象之间的交互。中介者使各对象之间不需要显式地相互引用，从而使其耦合松散，并可以独立地改变它们之间的交互。中介者模式将"网状"的多对多交互转化为"星型"的对象—中介者交互。

## 二、使用场景
- 多个对象之间存在复杂的交互关系，互相直接引用会导致紧耦合
- 一个对象的改变需要通知多个其他对象，但相互依赖关系难以维护
- 希望在不同场景下复用同一组对象，但它们的交互行为不同
- 例如：聊天室、对话框组件联动、机场塔台调度

## 三、结构
```
       Colleague  <------------------------+
        ^   ^   ^                          |
        |   |   |  sends/receives via       |
   ChatColleagueA ChatColleagueB           v
        \           /               +---------------+
         \         /                |   Mediator    |<-- ChatMediator
          \       /                 |  (abstract)   |
           \     /                  +---------------+
            \   /                          ^
             v                             | implements
        +---------------+                  |
        | ChatMediator  |<-----------------+
        +---------------+
```

## 四、角色说明
- **Mediator（抽象中介者）**：定义与同事对象交互的接口
- **ConcreteMediator（具体中介者）**：实现同事之间的交互逻辑，了解所有同事
- **Colleague（抽象同事）**：每个同事都知道中介者，与其他同事通信时通过中介者
- **ConcreteColleague（具体同事）**：实现具体业务，与其他同事通信时通过中介者转发

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/mediator/Colleague.java` —— 抽象同事
- `src/main/java/com/example/behavioral/mediator/ChatColleague.java` —— 聊天用户
- `src/main/java/com/example/behavioral/mediator/Mediator.java` —— 抽象中介者
- `src/main/java/com/example/behavioral/mediator/ChatMediator.java` —— 聊天室中介者
- `src/main/java/com/example/behavioral/mediator/MediatorDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 将多对多交互转化为星型交互，降低耦合
- 集中化交互逻辑，便于修改和复用
- 同事对象可独立演化，相互之间松耦合
- 符合迪米特法则（最少知道原则）

**缺点：**
- 中介者可能演变为"上帝对象"，承担过多职责
- 同事越多，中介者越复杂，难以维护

## 七、应用实例
- **JDK**：`java.util.Timer` 与 `TimerTask` 类似的中介调度；`java.util.concurrent.Executor` 调度任务
- **JDK**：`java.awt.Mediator` 风格的对话框组件联动（如 `Toolkit`）
- **Spring**：`ApplicationEventPublisher` 作为事件中介，组件通过发布/订阅解耦
- **常见**：机场塔台、聊天室、MVC 中的 Controller 充当中介

## 八、与相关模式对比
- **中介者 vs 观察者**：观察者通过订阅广播通信，中介者集中调度同事交互
- **中介者 vs 外观**：外面对子系统提供统一接口（单向）；中介者替换直接交互（双向）
- **中介者 vs 命令**：命令封装单个请求；中介者协调多个对象的交互

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.mediator.MediatorDemo"
```
