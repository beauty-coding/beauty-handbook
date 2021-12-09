package com.beauty.designpatterns.behavior;


import lombok.Data;

/**
 * 状态模式
 *
 * @author yufw
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.doWork();
        context.doWork();
    }

}

/**
 * 状态模式 配置类
 */
@Data
class Context {
    private State state;

    public Context() {
        this.state = new AState();
    }

    public void doWork() {
        state.doWork(this);
    }


}

/**
 * 状态接口
 */
interface State {

    void doWork(Context context);

}

/**
 * A 状态
 */
class AState implements State {

    @Override
    public void doWork(Context context) {

        System.out.println("初始状态：A");
        context.setState(new BState());
        System.out.println("状态转换后的状态B");

    }
}

/**
 * B 状态
 */
class BState implements State {

    @Override
    public void doWork(Context context) {

        System.out.println("初始状态：B");
        context.setState(new AState());
        System.out.println("状态转换后的状态A");

    }
}


