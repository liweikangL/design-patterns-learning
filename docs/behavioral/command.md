# 命令模式（Command）

## 一、意图
将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持撤销（undo）操作。命令模式把"动作"转化为可传递、可存储、可撤销的对象。

## 二、使用场景
- 需要将请求调用者与接收者解耦，使调用者无需知道接收者的具体实现
- 需要支持命令的排队、延迟执行、记录日志或事务回滚
- 需要支持撤销（undo）与重做（redo）操作
- GUI 按钮、菜单项、宏命令、任务调度系统等

## 三、结构
```
   Client
     |
     v
+--------------+        invokes        +--------------+
| RemoteControl| ------------------> |   Command    | (interface: execute/undo)
| (Invoker)    |                     +--------------+
+--------------+                            ^
     |                                      | implements
     | stores commands                      |
     v                                      v
+--------------+     has      +----------------------+
| command queue| --------->  | LightOnCommand / Off | --uses--> Light (Receiver)
+--------------+             +----------------------+
```

## 四、角色说明
- **Command（命令接口）**：声明执行 execute() 与撤销 undo() 的接口
- **ConcreteCommand（具体命令）**：实现命令，持有接收者引用，调用接收者完成实际工作
- **Receiver（接收者）**：真正执行业务逻辑的对象
- **Invoker（调用者）**：持有命令对象，在合适时机调用 execute/undo，可维护命令队列
- **Client（客户端）**：创建具体命令并装配到调用者

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/command/Command.java` —— 命令接口
- `src/main/java/com/example/behavioral/command/Light.java` —— 接收者（电灯）
- `src/main/java/com/example/behavioral/command/LightOnCommand.java` —— 开灯命令
- `src/main/java/com/example/behavioral/command/LightOffCommand.java` —— 关灯命令
- `src/main/java/com/example/behavioral/command/RemoteControl.java` —— 调用者（支持队列和撤销）
- `src/main/java/com/example/behavioral/command/CommandDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 调用者与接收者解耦，调用者无需知道接收者的实现
- 命令可被排队、记录日志、序列化，支持事务与延迟执行
- 易于扩展新命令，符合开闭原则
- 支持撤销与重做

**缺点：**
- 每个命令都需要一个具体命令类，命令多时类数量膨胀
- 命令对象本身有一定开销

## 七、应用实例
- **JDK**：`java.lang.Runnable` 是典型命令模式，将"运行任务"封装为对象交给线程执行
- **JDK**：`java.awt.Button` 的事件回调、`javax.swing.Action`
- **Spring**：`org.springframework.jdbc.core.JdbcTemplate` 中的 `StatementCallback`、`TransactionTemplate` 的回调
- **常见**：GUI 按钮点击、宏录制、消息队列任务

## 八、与相关模式对比
- **命令 vs 策略**：策略是"选择算法"，命令是"封装请求"；策略通常无撤销语义，命令天然支持撤销
- **命令 vs 责任链**：责任链强调"谁能处理"，命令强调"如何封装调用以便撤销/排队"
- **命令 vs 模板方法**：模板方法是固定流程骨架，命令是松散的一次性调用

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.command.CommandDemo"
```
