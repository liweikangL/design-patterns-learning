# 备忘录模式（Memento）

## 一、意图
在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时把该对象恢复到原先保存的状态。备忘录模式让"快照/回滚"行为与原对象解耦。

## 二、使用场景
- 必须保存一个对象在某一个时刻的状态，以便以后需要时恢复
- 不希望直接暴露对象内部状态（封装性）
- 需要实现撤销（undo）功能
- 事务回滚、检查点、游戏存档、对话历史快照

## 三、结构
```
   Client
     |
     v
+---------------+ createMemento()  +-----------+
| Originator    | ----------------> |  Memento  |
| (发起人)       | <---------------- | (备忘录)   |
+---------------+  setMemento()    +-----------+
     ^                                     ^
     |  uses                                | saves/restores
     v                                     v
+---------------+                     +-----------+
| Caretaker     | ------------------> |  Memento  |
| (管理者)      |    holds            |   pool    |
+---------------+                     +-----------+
```

## 四、角色说明
- **Memento（备忘录）**：保存发起人对象的内部状态，仅供发起人访问（封装保护）
- **Originator（发起人）**：创建备忘录记录自身状态，也可根据备忘录恢复状态
- **Caretaker（管理者）**：负责保存备忘录，但不能修改其内容
- **Client（客户端）**：触发发起人保存/恢复状态

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/memento/Memento.java` —— 备忘录
- `src/main/java/com/example/behavioral/memento/Originator.java` —— 发起人
- `src/main/java/com/example/behavioral/memento/Caretaker.java` —— 管理者
- `src/main/java/com/example/behavioral/memento/MementoDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 提供状态恢复机制，简化原对象的撤销逻辑
- 保持封装性，不暴露内部状态
- 把状态保存职责与原对象分离，符合单一职责原则

**缺点：**
- 状态庞大时，备忘录对象消耗内存
- 频繁保存可能带来性能开销
- 管理者长期保存备忘录可能造成内存累积

## 七、应用实例
- **JDK**：`java.io.Serializable` 序列化机制可视作备忘录的简化形式
- **JDK**：`java.util.Date` 的 `getTime`/`setTime`、`java.util.Calendar` 等
- **常见**：游戏存档、文本编辑器撤销栈、IDE 的本地历史（如 IntelliJ Local History）
- **Spring**：`TransactionStatus` 保存事务状态以支持回滚

## 八、与相关模式对比
- **备忘录 vs 命令**：命令可记录操作并撤销，备忘录保存完整快照；前者适合细粒度操作，后者适合整体状态
- **备忘录 vs 状态**：状态模式描述对象在不同状态下的行为；备忘录描述状态的保存与恢复
- **备忘录 vs 原型**：原型通过克隆创建新对象；备忘录保存现有状态供回滚

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.memento.MementoDemo"
```
