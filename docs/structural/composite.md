# 组合模式（Composite）

## 一、意图
将对象组合成树形结构以表示"部分-整体"层次，使客户端可以一致地处理单个对象和组合对象。组合模式属于结构型模式，递归构建树状结构，简化对层级数据的操作。

## 二、使用场景
- 表示树形结构：文件系统、组织架构、菜单/分类。
- 希望客户端忽略组合对象与叶子对象的差异，统一处理。
- 节点可以被递归遍历，且新增节点类型无需修改已有代码。

## 三、结构
```
        Component（抽象构件）
         ▲ - operation()
         │ + add() / remove() / getChildren()
        / \
       /   \
   Leaf     Composite（容器节点）
   （叶子）   │ children: List<Component>
   operation  │ + add() / remove()
              ▼
           operation() 内递归调用 children.operation()
```
- 透明式：管理方法上移到 Component，叶子调用管理方法时抛异常。
- 安全式：管理方法只在 Composite 中，叶子无法调用。

## 四、角色说明
- **Component 抽象构件**：叶子和容器的共同接口，声明业务方法和（可选的）管理方法。
- **Leaf 叶子节点**：叶子对象，没有子节点，实现业务方法。
- **Composite 容器节点**：存储子节点，实现管理方法，并在业务方法中递归调用子节点。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/composite/`，以文件系统目录树为例：
- `Component.java`：抽象构件，定义 `operation()` 与管理方法（透明式）。
- `Leaf.java`：文件叶子节点。
- `Composite.java`：目录容器节点，递归展示子树。
- `CompositeDemo.java`：构建多层级目录树并展示。

## 六、优缺点
**优点：**
- 统一处理叶子和容器，客户端代码简化，符合开闭原则。
- 方便新增节点类型，无需修改既有代码。
- 树形结构天然支持递归遍历。

**缺点：**
- 透明式难以限制叶子节点调用管理方法（运行时才报错）。
- 安全式又让客户端需要类型判断才能调用管理方法。
- 设计过于抽象时，难以约束组合关系（如"叶子不能作为父节点"）。

## 七、应用实例
- **JDK**：`java.awt.Container` 与 `Component` 形成组合关系，容器可嵌套子组件。
- **JDK**：`javax.swing.JTree` 的 `DefaultMutableTreeNode` 是典型组合节点。
- **MyBatis**：`SqlNode` 各种节点（IfNode/ForEachNode）组合成 SQL 模板树。
- **DOM**：XML/HTML 节点 `Node` 的父子节点结构。

## 八、与相关模式对比
- **Composite vs Decorator**：Composite 强调"部分-整体"的树形聚合；Decorator 强调单链叠加职责，且 Decorator 通常只有一个子构件。
- **Composite vs Iterator**：常与 Iterator 配合，对外提供统一的树遍历方式。
- **Composite vs Flyweight**：树节点很多时可结合享元共享叶子对象以节省内存。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.composite.CompositeDemo"
```
