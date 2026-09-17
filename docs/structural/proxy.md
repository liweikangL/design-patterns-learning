# 代理模式（Proxy）

## 一、意图
为其他对象提供一个代理以控制对原对象的访问。代理类与被代理对象实现同一接口，客户端通过代理间接访问真实对象，从而在调用前后可加入权限校验、日志、延迟加载、远程调用等横切逻辑。

## 二、使用场景
- 远程代理：为远程对象提供本地代表（RMI、RPC Stub）。
- 虚拟代理：延迟创建开销大的对象（如大图片懒加载）。
- 保护代理：根据权限控制对原对象的访问。
- 智能引用代理：在访问前后附加日志、缓存、计数等逻辑。

## 三、结构
```
        Client
          │ uses
          ▼
       Subject（interface）
       request()
          ▲
   ┌──────┴──────────┐
   │                 │
RealSubject        Proxy（静态代理 / 动态代理）
 真实业务            has-a RealSubject
                     request() { 前置; real.request(); 后置; }
```
- 静态代理：编译期写好代理类，组合持有真实主题。
- 动态代理：运行时通过 JDK `Proxy.newProxyInstance` 生成代理字节码，由 `InvocationHandler` 决定调用逻辑。

## 四、角色说明
- **Subject 抽象主题**：定义 RealSubject 与 Proxy 共有的接口。
- **RealSubject 真实主题**：承担实际业务逻辑的对象。
- **Proxy 代理**：持有真实主题引用，在调用前后加入控制逻辑。
- **InvocationHandler 调用处理器**：动态代理的核心，统一拦截方法调用。

## 五、代码示例
本仓库示例位于 `src/main/java/com/example/structural/proxy/`：
- `Subject.java`：抽象主题接口。
- `RealSubject.java`：真实主题，实现 `request()`。
- `StaticProxy.java`：静态代理，前后织入日志/权限。
- `DynamicProxyHandler.java`：JDK 动态代理，实现 `InvocationHandler`。
- `ProxyDemo.java`：演示静态代理与动态代理两种方式。

## 六、优缺点
**优点：**
- 代理类与真实主题解耦，可在不修改原对象前提下增强控制。
- 动态代理一个处理器可代理任意接口，扩展性强，是 AOP 的基础。
- 可实现延迟加载、远程访问、权限控制等横切关注点。

**缺点：**
- 增加间接层，调用链变长，可能带来性能开销。
- 静态代理类数量随接口增多而膨胀，维护成本高。
- JDK 动态代理只能代理接口实现类；要代理类需用 CGLIB 等字节码工具。

## 七、应用实例
- **Spring AOP**：基于 JDK 动态代理或 CGLIB 生成代理 Bean，实现声明式事务、缓存、日志等横切逻辑。
- **JDK**：`java.lang.reflect.Proxy` + `InvocationHandler` 是动态代理的标准实现。
- **RPC 框架**：Dubbo/gRPC 的客户端 Stub 即远程代理，把网络调用伪装成本地方法调用。
- **MyBatis**：Mapper 接口的代理实现（MapperProxy）让接口方法自动映射到 SQL 执行。

## 八、与相关模式对比
- **Proxy vs Decorator**：Proxy 侧重访问控制（代理者不一定增强功能）；Decorator 侧重叠加职责，且接口不变。
- **Proxy vs Adapter**：Proxy 与真实主题实现同一接口；Adapter 转换接口使不兼容对象协同。
- **Proxy vs Facade**：Proxy 控制对单个对象的访问；Facade 为一组对象提供简化入口。

## 九、运行示例
```bash
mvn -q exec:java -Dexec.mainClass="com.example.structural.proxy.ProxyDemo"
```
