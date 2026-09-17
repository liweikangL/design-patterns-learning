# 适配器模式（Adapter）

## 一、意图
将一个类的接口转换成客户端期望的另一个接口，使原本因接口不兼容而无法一起工作的类可以协同工作。适配器模式属于结构型模式，它包装一个已存在的类，对外提供客户端需要的目标接口。

## 二、使用场景
- 需要使用一个已经存在的类，但其接口与所需接口不匹配。
- 想复用若干既有类，且它们位于彼此独立的子系统中，缺乏统一接口。
- 第三方库、遗留代码升级后接口发生变化，又不希望修改调用方代码。

## 三、结构
```
        Client                Target（interface）
          |  uses                  ▲ request()
          |                        |
          +----> Adapter -----------+
                  |  has-a (对象适配器) / extends (类适配器)
                  v
               Adaptee
               specificRequest()
```
- 对象适配器：Adapter 实现 Target，组合持有 Adaptee，在 request() 中委派 Adaptee。
- 类适配器：Adapter extends Adaptee implements Target，直接调用父类方法。

## 四、角色说明
- **Target 目标接口**：客户端期望的接口，定义客户端可调用的方法。
- **Adaptee 被适配者**：已存在的类，含可用功能但接口不兼容。
- **Adapter 适配器**：把 Adaptee 的接口转换成 Target 接口，承担转换职责。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/adapter/`：
- `Target.java`：目标接口，定义 `request()`。
- `Adaptee.java`：被适配者，提供 `specificRequest()`。
- `ObjectAdapter.java`：对象适配器，组合方式（推荐）。
- `ClassAdapter.java`：类适配器，继承方式。
- `AdapterDemo.java`：演示两种适配器用法。

## 六、优缺点
**优点：**
- 让不兼容的类协同工作，无需修改既有代码，符合开闭原则。
- 复用既有类，灵活性高（对象适配器可适配 Adaptee 及其子类）。
- 将接口转换逻辑与业务逻辑分离。

**缺点：**
- 类适配器受 Java 单继承限制，且对 Adaptee 子类无法灵活适配。
- 对象适配器需要额外引入一个对象，增加间接性。
- 过多适配器会让系统变得零碎难懂。

## 七、应用实例
- **JDK**：`java.io.InputStreamReader` / `OutputStreamWriter` 把字节流 `InputStream` 适配为字符流 `Reader`，是典型的对象适配器。
- **JDK**：`java.util.Arrays.asList(T...)` 将数组接口适配为 `List` 接口。
- **Spring**：`HandlerAdapter` 把不同类型的 Controller 适配到统一的 `handle()` 调用。

## 八、与相关模式对比
- **Adapter vs Facade**：Adapter 改接口让现有类可用，强调一对一转换；Facade 为复杂子系统提供统一简化的新接口，强调一对多聚合。
- **Adapter vs Decorator**：Adapter 改变接口以适配需求，不增加功能；Decorator 保持接口不变，增加职责。
- **Adapter vs Proxy**：Adapter 让接口变得兼容，关注接口转换；Proxy 控制对原对象的访问，关注访问控制。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.adapter.AdapterDemo"
```
