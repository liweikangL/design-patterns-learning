# 责任链模式（Chain of Responsibility）

## 一、意图
将请求的发送者和接收者解耦，使多个对象都有机会处理同一个请求。将这些对象连成一条链，并沿着链传递请求，直到有一个对象处理它为止。客户端无需知道链上的具体处理者，只需把请求提交给链的入口即可。

## 二、使用场景
- 多个对象可以处理同一请求，但具体由谁处理需在运行时动态决定
- 想在不明确指定接收者的情况下，向多个对象中的一个提交请求
- 处理者集合应当能够动态配置（如按顺序、按权限、按层级）
- 例如：日志级别处理、审批流、Web 过滤器、异常处理链

## 三、结构
```
        Client
          |
          v
   +---------------+
   |   Handler     |<--------+ (next)
   |  (abstract)   |         |
   +---------------+         |
     |    |                  |
     | successor             |
     v                       |
   +---------------+    +---------------+
   | ConcreteHandlerA | | ConcreteHandlerB | -> ... -> 兜底处理者
   +---------------+    +---------------+
```

链上每个处理者持有下一个处理者的引用；如果自己无法处理，就把请求传给后继者。

## 四、角色说明
- **Handler（抽象处理者）**：定义处理请求的接口，并持有后继者的引用
- **ConcreteHandler（具体处理者）**：实现处理逻辑，能处理则处理，不能处理则交给后继者
- **Client（客户端）**：组装链，并向链头发起请求

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/chain/Handler.java` —— 抽象处理者
- `src/main/java/com/example/behavioral/chain/ConcreteHandlerA.java` —— 处理级别 ≤ 10
- `src/main/java/com/example/behavioral/chain/ConcreteHandlerB.java` —— 处理级别 ≤ 20
- `src/main/java/com/example/behavioral/chain/ConcreteHandlerC.java` —— 兜底处理者
- `src/main/java/com/example/behavioral/chain/ChainDemo.java` —— 演示入口

链路：A → B → C，未被前序处理者处理的请求最终由 C 兜底。

## 六、优缺点
**优点：**
- 发送者与接收者解耦，发送者无需知道谁处理
- 链结构可动态调整，新增/移除处理者不影响其他类
- 符合单一职责原则，每个处理者只关心自己能处理的请求
- 符合开闭原则，新增处理者无需修改既有代码

**缺点：**
- 请求可能到达链尾仍未被处理（必须设计兜底）
- 调试困难，运行时才能确定实际处理者
- 链过长会影响性能，且可能产生调用栈过深

## 七、应用实例
- **JDK**：`java.util.logging.Logger` 通过父 logger 传递日志；`javax.servlet.Filter` 在 `FilterChain` 中依次调用
- **Servlet**：`FilterChain` 是典型责任链，多个 Filter 依次处理请求
- **Spring**：`HandlerInterceptor` 拦截器链、Spring Security 的 `FilterChainProxy`
- **Netty**：`ChannelPipeline` 中的 `ChannelHandler` 链

## 八、与相关模式对比
- **责任链 vs 策略**：策略模式客户端主动选择一个策略；责任链由链上对象自行决定处理或传递
- **责任链 vs 装饰器**：装饰器一定会传递调用并增强；责任链可以选择是否继续传递
- **责任链 vs 命令**：命令模式关注"封装请求为对象"；责任链关注"谁来处理请求"

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.chain.ChainDemo"
```
