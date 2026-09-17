# 外观模式（Facade）

## 一、意图
为子系统中的一组接口提供一个一致的界面（统一入口）。外观模式定义了一个高层接口，使子系统更易于使用，并降低客户端与子系统之间的耦合。

## 二、使用场景
- 子系统复杂、接口众多，需要为常用功能提供简化入口。
- 客户端与子系统多层模块耦合，希望减少依赖。
- 系统分层时，为每层提供一个对外观入口，层间仅通过外观通信。

## 三、结构
```
           Client
             │ uses
             ▼
         Facade（Computer）
        /   |    \
       has-a has-a has-a
       ▼    ▼    ▼
      CPU Memory HardDrive   <- 子系统
```
外观持有各子系统引用，把多步调用编排成一个对外的简单方法。

## 四、角色说明
- **Facade 外观**：聚合子系统，提供简化的统一接口。
- **Subsystem 子系统**：各自独立的复杂模块，可被外观组合调用，也可独立使用。
- **Client 客户端**：只依赖外观，无需了解子系统细节。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/facade/`：
- `CPU.java`、`Memory.java`、`HardDrive.java`：三个子系统。
- `Computer.java`：外观类，提供 `start()` / `stop()` 统一入口。
- `FacadeDemo.java`：演示一键启停计算机。

## 六、优缺点
**优点：**
- 简化客户端调用，屏蔽子系统复杂性。
- 降低客户端与子系统的耦合，符合最少知识原则（迪米特法则）。
- 子系统仍可独立使用，外观并不限制访问。

**缺点：**
- 增加外观类，若滥用会让外观层变得臃肿。
- 不能强行限制客户端直接访问子系统。
- 新增子系统可能需要修改外观（违背开闭原则）。

## 七、应用实例
- **Spring JDBC**：`JdbcTemplate` 封装 DataSource、Statement、ResultSet 操作，是数据访问外观。
- **Slf4j**：统一的日志门面，背后可切换 Logback/Log4j 等实现。
- **MyBatis**：`SqlSession` 把 Executor、StatementHandler、ResultSetHandler 编排成简洁 API。
- **Tomcat**：`Request`/`Response` 外观封装底层 Socket 与容器组件。

## 八、与相关模式对比
- **Facade vs Adapter**：Facade 提供简化入口，子系统接口本身没变；Adapter 改变接口让对象可用。
- **Facade vs Mediator**：Facade 单向简化对外接口，子系统彼此不通信；Mediator 双向协调同事对象间交互。
- **Facade vs Proxy**：Facade 聚合多个对象提供新接口；Proxy 控制单个对象的访问。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.facade.FacadeDemo"
```
