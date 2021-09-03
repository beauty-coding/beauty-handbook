package com.beauty.designpatterns.behavior;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class StrategyPattern {

    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new AddStrategy());

        System.out.println(strategyContext.operate(10, 2));

        System.out.println("=============");
        strategyContext = new StrategyContext((num1, num2) -> num1*num2);
        System.out.println(strategyContext.operate(10, 2));
    }

}

/**
 * 策略接口
 */
interface Strategy{

    int operate(int num1, int num2);

}

/**
 * 加法策略
 */
class AddStrategy implements Strategy{

    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}

/**
 * 减法策略
 */
class SubStrategy implements Strategy{

    @Override
    public int operate(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * 策略模式配置类
 */
class StrategyContext{
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int operate(int num1, int num2){
        return strategy.operate(num1, num2);
    }
}



// =========================练习题状态，应用案例=============================


/**
 * 练习状态配置类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class HomeworkStatusContext {
    private HomeworkStatus homeworkStatus;

    public void changeStatus() {
        homeworkStatus.changeStatus();
    }

}

@Data
abstract class HomeworkStatus {

    private String name;

    private Integer state;

    private Long number;

    public void checkStatus() {
        System.out.println("判断 status值 是否在 枚举范围内");
    }

    public void changeStatus() {
        checkStatus();
        changeStatusValue();

        System.out.println("修改数据库值");

    }

    protected abstract void changeStatusValue();

}

/**
 * 保存态
 */
@EqualsAndHashCode(callSuper = true)
@Data
class SaveHomeworkStatus extends HomeworkStatus {

    @Override
    protected void changeStatusValue() {
        this.setName("保存态");
        this.setState(0);
        this.setNumber(getNumber());
    }
}

/**
 * 提交态
 */
class CommitHomeworkStatus extends HomeworkStatus {
    @Override
    protected void changeStatusValue() {
        this.setName("提交态");
        this.setState(10);
        this.setNumber(getNumber());
    }
}

/**
 * 未通过态
 */
class NoPassHomeworkStatus extends HomeworkStatus {
    @Override
    protected void changeStatusValue() {
        this.setName("未通过态");
        this.setState(20);
        this.setNumber(getNumber());
    }
}

/**
 * 通过态
 */
class PassHomeworkStatus extends HomeworkStatus {
    @Override
    protected void changeStatusValue() {
        this.setName("通过态");
        this.setState(30);
        this.setNumber(getNumber());
    }
}
