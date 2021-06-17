package com.beauty.designpatterns.xingwei;

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
