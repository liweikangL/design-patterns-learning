package com.example.behavioral.state;

/**
 * 启动状态（StartState）。
 * 在处理请求时打印"启动"行为，并将上下文的下一状态切换为停止状态，
 * 即由状态对象自身决定下一个状态。
 */
public class StartState implements State {

    /**
     * 启动状态下处理请求，并切换到停止状态。
     *
     * @param context 状态上下文
     */
    @Override
    public void handle(Context context) {
        System.out.println("当前状态：启动状态 —— 执行启动逻辑（如打开资源、开始计时）");
        // 由状态对象自身决定下一个状态
        context.setState(new StopState());
    }

    @Override
    public String name() {
        return "启动状态";
    }
}
