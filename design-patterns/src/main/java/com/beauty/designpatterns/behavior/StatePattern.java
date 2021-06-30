package com.beauty.designpatterns.behavior;

/**
 * 状态模式
 * @author yufw
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.changeState(new AState());
        context.doWork();
        System.out.println("===============");
        context.changeState(new BState());
        context.doWork();

    }

}

/**
 * 状态模式 配置类
 */
class Context{
    private State state;

    public void changeState(State state){

        this.state = state;

    }

    public void doWork(){
        state.doWork();
    }



}

/**
 * 状态接口
 */
interface State{

    void doWork();

}

/**
 * A 状态
 */
class AState implements State{

    @Override
    public void doWork() {

        System.out.println("A");

    }
}
/**
 * B 状态
 */
class BState implements State{

    @Override
    public void doWork() {

        System.out.println("B");

    }
}


