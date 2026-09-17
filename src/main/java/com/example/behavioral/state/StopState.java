package com.example.behavioral.state;

/**
 * 停止状态（StopState）。
 * 在处理请求时打印"停止"行为，并将上下文的下一状态切换为启动状态，
 * 即由状态对象自身决定下一个状态。
 */
public class StopState implements State {

    /**
     * 停止状态下处理请求，并切换到启动状态。
     *
     * @param context 状态上下文
     */
    @Override
    public void handle(Context context) {
        System.out.println("当前状态：停止状态 —— 执行停止逻辑（如释放资源、停止计时）");
        // 由状态对象自身决定下一个状态
        context.setState(new StartState());
    }

    @Override
    public String name() {
        return "停止状态";
    }
}
