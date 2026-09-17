package com.example.behavioral.state;

/**
 * 抽象状态（State）。
 * 声明状态行为接口；具体状态实现该接口，
 * 在处理时自行决定下一个状态并写回上下文。
 */
public interface State {

    /**
     * 处理上下文的请求，由具体状态决定具体行为与状态切换。
     *
     * @param context 状态上下文
     */
    void handle(Context context);

    /**
     * 返回状态名称，用于打印。
     *
     * @return 状态名称
     */
    String name();
}
