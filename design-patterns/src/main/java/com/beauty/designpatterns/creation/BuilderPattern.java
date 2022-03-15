package com.beauty.designpatterns.creation;

/**
 * 建造者模式
 * <p>
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Builder builder = new RealBuilder();
        Salesperson director = new Salesperson(builder);
        Meal product = director.construct();
        product.ok();
    }

}


/**
 * 需求：
 * 麦当劳点餐
 * 一个汉堡、一杯可乐、一个鸡米花
 */

/**
 * product 产品 套餐
 */
class Meal {

    private String stapleFood;
    private String drink;
    private String snack;

    public Meal() {
    }

    public String getStapleFood() {
        return stapleFood;
    }

    public void setStapleFood(String stapleFood) {
        this.stapleFood = stapleFood;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public void ok(){
        System.out.println(drink);
        System.out.println(snack);
        System.out.println(stapleFood);
        System.out.println("上菜");
    }
}

/**
 * Director 指挥者 销售前台
 */
class Salesperson {

    private final Builder builder;

    public Salesperson(Builder builder) {
        this.builder = builder;
    }

    public Meal construct(){
        builder.buildDrink();
        builder.buildStapleFood();
        builder.buildSnack();
        return builder.getResult();
    }

}

/**
 * 大厨 生产者
 */
abstract class Builder{

    Meal product = new Meal();

    public abstract void buildStapleFood();
    public abstract void buildDrink();
    public abstract void buildSnack();

    public Meal getResult(){
        return product;
    }

}

/**
 * 实际建造者
 */
class RealBuilder extends Builder{

    @Override
    public void buildStapleFood() {
        product.setStapleFood("汉堡做好了");
    }

    @Override
    public void buildDrink() {

        product.setDrink("可乐做好了");
    }

    @Override
    public void buildSnack() {
        product.setSnack("鸡米花做好了");
    }

}


