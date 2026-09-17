# 观察者模式（Observer）

## 一、意图
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。观察者模式让主题与观察者松耦合，便于动态增减观察者。

## 二、使用场景
- 一个对象的改变将导致其他对象做出反应，且不知道具体有多少对象需要被通知
- 希望在运行时动态增删观察者而不修改主题
- 需要实现事件广播、订阅/发布、数据绑定等场景
- MVC 中模型与视图的解耦

## 三、结构
```
                  Subject (abstract)
                   |  attach() / detach() / notify()
                   |---------------------------+
                   |                           |
              +----+----+              +------+------+
              |         |              |             |
       ConcreteSubject         Observer (abstract)
         |  getState()            |  update()
         |                        ^   ^
         |                        |   |
         v                        |   |
   notifies all observers    ConcreteObserverA  ConcreteObserverB
```

## 四、角色说明
- **Subject（抽象主题）**：维护观察者集合，提供注册/移除/通知接口
- **ConcreteSubject（具体主题）**：实现通知逻辑，状态变更时调用观察者 update()
- **Observer（抽象观察者）**：声明接收通知的方法 update()
- **ConcreteObserver（具体观察者）**：实现 update()，从主题获取自己感兴趣的数据

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/observer/Subject.java` —— 抽象主题
- `src/main/java/com/example/behavioral/observer/ConcreteSubject.java` —— 具体主题
- `src/main/java/com/example/behavioral/observer/Observer.java` —— 抽象观察者
- `src/main/java/com/example/behavioral/observer/ConcreteObserverA.java` —— 观察者 A
- `src/main/java/com/example/behavioral/observer/ConcreteObserverB.java` —— 观察者 B
- `src/main/java/com/example/behavioral/observer/ObserverDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 主题与观察者松耦合，互不关心对方的具体实现
- 支持广播通信，主题无需知道观察者数量
- 可在运行时增删观察者，符合开闭原则
- 符合"高层不依赖低层"的依赖倒置原则

**缺点：**
- 观察者过多时，主题通知开销大
- 观察者之间可能存在依赖，导致行为难以预测
- 若观察者之间存在循环引用，可能引发无限通知
- 默认实现下不保证通知顺序

## 七、应用实例
- **JDK**：`java.util.Observable` / `Observer`（已废弃但概念经典）、`java.util.EventListener` 体系
- **JDK**：`PropertyChangeListener`、`java.beans` 中的事件模型
- **Spring**：`ApplicationEvent` / `ApplicationListener`、`@EventListener`、`ApplicationEventPublisher`
- **常见**：消息总线（Kafka）、RxJava/Reactor 响应式流、Vue 双向绑定、GUI 事件监听

## 八、与相关模式对比
- **观察者 vs 中介者**：观察者通过订阅广播，中介者集中调度同事交互
- **观察者 vs 发布订阅**：发布订阅通常通过中间 broker 解耦发布者和订阅者；观察者主题直接持有观察者
- **观察者 vs 责任链**：观察者一对多广播；责任链一对一传递

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.observer.ObserverDemo"
```
