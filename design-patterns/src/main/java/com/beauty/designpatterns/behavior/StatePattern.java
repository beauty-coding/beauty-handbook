package com.beauty.designpatterns.behavior;


import lombok.Data;

/**
 * 状态模式
 *
 * @author yufw
 */
public class StatePattern {

    public static void main(String[] args) {
        StatusContext context = new StatusContext();
        context.handle(null);
        context.handle(20);
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


// ========================== ==========================


/**
 * 状态模式 配置类
 */
@Data
class StatusContext {
    private HomeworkState state;
    private Integer stateValue;

    public StatusContext() {
        this.state = new SaveState();
    }

    public void handle(Integer stateValue) {
        this.setStateValue(stateValue);
        System.out.println("状态前："+this.getState().toString());
        state.handle(this);
        System.out.println("状态后："+this.getState().toString());
    }


}

/**
 * 状态接口
 */
abstract class HomeworkState {

    void handle(StatusContext context){

        System.out.println("写数据库");
        changeState(context);
    }


    abstract void changeState(StatusContext context);

}

/**
 * A 状态
 */
class SaveState extends HomeworkState {

    @Override
    public void changeState(StatusContext context) {

        context.setState(new CommitState());

    }
}

/**
 * 提交 状态
 */
class CommitState extends HomeworkState {

    @Override
    public void changeState(StatusContext context) {

        HomeworkState state;
        if (context.getStateValue()==20) {
            state = new NoPassState();
        } else if (context.getStateValue()==30){
            state = new PassState();
        } else {
            state = context.getState();
        }
        context.setState(state);
        System.out.println("微信通知"+state.toString());

    }
}


/**
 * 未通过 状态
 */
class NoPassState extends HomeworkState {

    @Override
    void changeState(StatusContext context) {

    }
}



/**
 * 通过 状态
 */
class PassState extends HomeworkState {

    @Override
    void changeState(StatusContext context) {

    }
}
