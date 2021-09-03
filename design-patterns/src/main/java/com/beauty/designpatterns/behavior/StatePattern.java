package com.beauty.designpatterns.behavior;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 状态模式
 *
 * @author yufw
 */
public class StatePattern {

    public static void main(String[] args) {
    }

}

/**
 * 状态模式 配置类
 */
class Context {
    private State state;

    public void changeState(State state) {

        this.state = state;

    }

    public void doWork() {
        state.doWork();
    }


}

/**
 * 状态接口
 */
interface State {

    void doWork();

}

/**
 * A 状态
 */
class AState implements State {

    @Override
    public void doWork() {

        System.out.println("A");

    }
}

/**
 * B 状态
 */
class BState implements State {

    @Override
    public void doWork() {

        System.out.println("B");

    }
}

