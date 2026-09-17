# 迭代器模式（Iterator）

## 一、意图
提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露该对象的内部表示。迭代器把"遍历"这一行为从聚合对象中抽离出来，使聚合对象无需关心遍历细节。

## 二、使用场景
- 需要访问一个聚合对象的内容而不暴露其内部表示（如数组、列表、树）
- 希望为同一聚合提供多种遍历方式（前序、中序、后序、广度等）
- 希望为不同的聚合结构提供统一的遍历接口
- 需要支持多种遍历策略或并发遍历

## 三、结构
```
   Client
     |
     v
+---------------+        creates        +---------------+
| Aggregate     | --------------------> |   Iterator    |
| (interface)   |                       |  (interface)  |
+---------------+                       +---------------+
     ^                                          ^
     | implements                            implements
     |                                          |
+---------------+                          +---------------+
| NameRepository| ----uses---->            |  NameIterator |
+---------------+                          +---------------+
```

## 四、角色说明
- **Aggregate（聚合接口）**：声明创建迭代器的方法 createIterator()
- **Iterator（迭代器接口）**：声明 hasNext() 与 next() 等遍历方法
- **ConcreteAggregate（具体聚合）**：实现聚合接口，返回与自身结构匹配的具体迭代器
- **ConcreteIterator（具体迭代器）**：实现遍历算法，跟踪当前位置

## 五、代码示例
本仓库示例对应文件：
- `src/main/java/com/example/behavioral/iterator/Aggregate.java` —— 聚合接口
- `src/main/java/com/example/behavioral/iterator/Iterator.java` —— 迭代器接口
- `src/main/java/com/example/behavioral/iterator/NameRepository.java` —— 名字仓库（具体聚合）
- `src/main/java/com/example/behavioral/iterator/NameIterator.java` —— 名字迭代器（具体迭代器）
- `src/main/java/com/example/behavioral/iterator/IteratorDemo.java` —— 演示入口

## 六、优缺点
**优点：**
- 符合单一职责原则，把遍历逻辑从聚合中分离
- 符合开闭原则，可新增迭代器而无需修改聚合
- 可对同一聚合提供多种遍历方式
- 提供统一接口，简化客户端代码

**缺点：**
- 对于简单集合，引入迭代器略显繁琐
- 在某些语言中可能比直接遍历慢（在现代 JVM 中影响很小）

## 七、应用实例
- **JDK**：`java.util.Iterator` 接口及其子接口 `ListIterator`；`java.lang.Iterable` 是聚合接口
- **JDK**：增强 for 循环底层依赖 `Iterable`
- **JDK**：`java.util.Scanner`、`ResultSet` 提供类似遍历能力
- **常见**：Map 的 `keySet().iterator()`、Collection 的 stream 与 spliterator

## 八、与相关模式对比
- **迭代器 vs 访问者**：迭代器按顺序访问元素；访问者对元素施加不同操作
- **迭代器 vs 组合**：组合模式构建树形结构，常配合迭代器做层次遍历
- **迭代器 vs 备忘录**：备忘录保存状态用于回滚，迭代器只向前遍历

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.behavioral.iterator.IteratorDemo"
```
