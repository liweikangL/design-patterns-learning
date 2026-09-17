# 桥接模式（Bridge）

## 一、意图
将抽象部分与实现部分分离，使它们都可以独立变化。桥接模式用组合代替继承，把两个独立变化的维度（如形状与颜色）解耦，避免多维度组合造成的子类爆炸。

## 二、使用场景
- 类存在两个独立变化的维度，且都希望独立扩展。
- 不希望使用继承或继承层次过多导致子类爆炸。
- 实现维度的切换需要在运行时进行，且不希望修改抽象代码。

## 三、结构
```
Abstraction（Shape）
   │  has-a  Color (Implementor)
   │
   ▲ extends                       ▲ implements
   │                               │
RefinedAbstraction        ConcreteImplementor(RedColor/BlueColor)
```
抽象化持有实现化引用，调用实现化接口；具体实现化由子类提供。

## 四、角色说明
- **Abstraction 抽象化**：定义抽象接口，持有实现化引用，将业务方法委派给实现化。
- **RefinedAbstraction 扩展抽象化**：扩展 Abstraction，添加额外行为。
- **Implementor 实现化**：定义实现维度的接口，供抽象化调用。
- **ConcreteImplementor 具体实现化**：实现 Implementor，提供具体实现。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/bridge/`：
- `Shape.java`：抽象化角色，持有 `Color`。
- `RefinedShape.java`：扩展抽象化，绘制轮廓并上色。
- `Color.java`：实现化接口。
- `RedColor.java` / `BlueColor.java`：具体实现化。
- `BridgeDemo.java`：演示形状与颜色自由组合。

## 六、优缺点
**优点：**
- 分离抽象与实现，二者可独立扩展，符合开闭原则。
- 避免多维度继承带来的子类爆炸（m*n 降为 m+n）。
- 实现细节对客户端透明，运行时可切换实现。

**缺点：**
- 增加系统理解成本，需正确识别两个独立变化维度。
- 通过组合间接调用，增加一层抽象。

## 七、应用实例
- **JDBC**：`DriverManager` 桥接抽象的 `Connection` 接口与各数据库厂商的具体 Driver 实现。
- **AWT/Swing**：`Component` 抽象与 `peer` 平台实现分离。
- **SLF4J**：日志门面（抽象）与 Logback/Log4j 等具体实现桥接。

## 八、与相关模式对比
- **Bridge vs Adapter**：Bridge 在设计阶段分离两个独立维度，关注结构解耦；Adapter 在事后让不兼容接口协同，关注接口转换。
- **Bridge vs Strategy**：Bridge 强调"实现维度"作为长期结构存在，二者共同演化；Strategy 强调算法可替换，关注行为变化。
- **Bridge vs Decorator**：Bridge 分离两个维度；Decorator 在接口不变下叠加职责。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.bridge.BridgeDemo"
```
