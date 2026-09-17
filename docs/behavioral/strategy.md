# 策略模式（Strategy）

## 一、意图
定义一系列算法，把它们一个个封装起来，并且使它们可相互替换。策略模式使算法的变化独立于使用算法的客户端，客户端可在运行时选择具体策略。

## 二、使用场景
- 多种算法或行为在运行时被选择使用
- 需要避免使用多重条件分支（if/else、switch）来选择算法
- 算法需要灵活切换，且希望对客户端透明
- 例如：计算器、排序算法选择、支付方式选择、促销折扣

## 三、结构
```
   Client
     |
     v
+---------------+  uses    +----------------+
|   Context     | -------> |   Strategy     | (interface)
| (上下文)       | <------- |                |
+---------------+  setStrategy +------------+
                                  ^
                                  | implements
   +----------+    +-----------+  |   +-----------+
   | Add      |    | Subtract  |      | Multiply  |
   +----------+    +-----------+      +-----------+
```

## 四、角色说明
- **Strategy（策略接口）**：声明算法接口
- **ConcreteStrategy（具体策略）**：实现具体算法
- **Context（上下文）**：持有策略引用，可被运行时替换，将算法调用委托给当前策略
- **Client（客户端）**：在运行时为上下文注入合适的策略

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/strategy/Strategy.java` —— 策略接口
- `src/main/java/com/example/behavioral/strategy/AddStrategy.java` —— 加法
- `src/main/java/com/example/behavioral/strategy/SubtractStrategy.java` —— 减法
- `src/main/java/com/example/behavioral/strategy/MultiplyStrategy.java` —— 乘法
- `src/main/java/com/example/behavioral/strategy/Context.java` —— 上下文
- `src/main/java/com/example/behavioral/strategy/StrategyDemo.java` —— 演示入口

演示了运行时切换加、减、乘三种策略的计算器。

## 六、优缺点
**优点：**
- 算法可独立演化与切换，符合开闭原则
- 避免复杂的条件分支语句
- 算法实现细节对客户端透明
- 策略可复用

**缺点：**
- 策略类数量膨胀
- 客户端需要了解各策略的差异以做出选择
- 上下文与策略间存在一定通信开销

## 七、应用实例
- **JDK**：`java.util.Collections.sort(List, Comparator)` 通过传入不同的 `Comparator` 切换排序策略
- **JDK**：`java.util.concurrent.ThreadPoolExecutor` 拒绝策略 `RejectedExecutionHandler`
- **JDK**：`javax.swing.JComboBox` 的 `KeySelectionManager`
- **Spring**：`Resource` 接口的不同实现（`ClassPathResource`/`FileSystemResource`），策略可运行时替换
- **常见**：支付方式选择、促销规则、折扣计算

## 八、与相关模式对比
- **策略 vs 状态**：策略由客户端主动选择；状态由对象内部根据当前状态切换，客户端不感知
- **策略 vs 命令**：策略是算法封装；命令是请求封装（可排队、撤销）
- **策略 vs 简单工厂**：工厂负责创建对象；策略关注算法的可替换使用

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.strategy.StrategyDemo"
```
