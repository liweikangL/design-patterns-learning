package com.example.structural.proxy;

/**
 * 真实主题（RealSubject）。
 * <p>
 * 真正承担业务逻辑的对象。直接调用通常开销较大或需要额外控制访问，
 * 因此常由代理在前后加入权限校验、日志、延迟加载等逻辑。
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("    RealSubject.request() 真正执行业务逻辑");
    }
}
