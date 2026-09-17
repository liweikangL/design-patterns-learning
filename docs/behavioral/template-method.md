# 模板方法模式（Template Method）

## 一、意图
定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。它通过在父类定义"骨架方法"和"抽象方法"，由子类填充具体步骤。

## 二、使用场景
- 一次性实现算法的不变部分，把可变部分留作子类实现
- 各子类公共行为应提取到父类，避免代码重复
- 控制子类扩展的扩展点
- 框架的"钩子方法"与"模板方法"分离

## 三、结构
```
   Client
     |
     v
+---------------------+
|   AbstractClass     | (templateMethod 定义骨架)
|  - templateMethod() | -> fixed flow: step1 -> step2 -> hook
|  + step1() abstract |
|  + step2() abstract |
|  + hook()  default  |
+---------------------+
         ^
         | extends
+---------------------+
|  ConcreteClassA / B |
|  step1() step2()   |  (可选择性覆盖 hook)
+---------------------+
```

## 四、角色说明
- **AbstractClass（抽象类）**：定义抽象方法 primitive1()/primitive2()，并实现模板方法 templateMethod() 调用它们；可选地提供钩子方法 hook()，默认实现可被子类覆盖
- **ConcreteClass（具体子类）**：实现抽象方法以完成具体步骤，可选覆盖钩子方法改变流程

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/template/AbstractClass.java` —— 抽象模板（含抽象方法和钩子方法）
- `src/main/java/com/example/behavioral/template/ConcreteClassA.java` —— 具体类 A
- `src/main/java/com/example/behavioral/template/ConcreteClassB.java` —— 具体类 B
- `src/main/java/com/example/behavioral/template/TemplateDemo.java` —— 演示入口

抽象模板定义 `templateMethod`（骨架），其中调用抽象方法 `primitiveOperation()` 与钩子方法 `hook()`，子类按需实现。

## 六、优缺点
**优点：**
- 在不改变算法结构的情况下重定义部分步骤
- 公共逻辑集中到父类，避免代码重复
- 通过钩子方法提供更灵活的扩展点
- 反向控制：父类调用子类实现

**缺点：**
- 子类按父类骨架实现，耦合较高
- 子类越多，维护成本越大
- 改动父类骨架会影响所有子类

## 七、应用实例
- **JDK**：`java.util.AbstractList` 的 `get()` 等需要子类实现；`java.io.InputStream` 的 `read(byte[], int, int)` 模板
- **JDK**：`javax.servlet.http.HttpServlet` 的 `doGet/doPost` 由子类实现，`service()` 是模板方法
- **JDK**：`AbstractQueuedSynchronizer` 的 `tryAcquire` 等模板方法
- **Spring**：`JdbcTemplate`、`RestTemplate`、`RedisTemplate` 均基于模板方法

## 八、与相关模式对比
- **模板方法 vs 策略**：模板方法通过继承改变部分步骤；策略通过组合替换整个算法
- **模板方法 vs 工厂方法**：工厂方法是模板方法的一种特化，关注"创建对象"的骨架
- **模板方法 vs 命令**：模板方法是固定流程；命令是松散封装的单次请求

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.template.TemplateDemo"
```
