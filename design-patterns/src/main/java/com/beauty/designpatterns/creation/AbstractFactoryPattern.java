package com.beauty.designpatterns.creation;

/**
 * description
 * 抽象工厂模式将考虑多等级产品的生产，将同一个具体工厂所生产的位于不同等级的一组产品称为一个产品族
 * 是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 * <p>
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 * <p>
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
 * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。
 * <p>
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。
 * <p>
 * 1. 模式的结构
 * 抽象工厂模式的主要角色如下。
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 *
 * @author yufengwen
 * @date 2021/12/10 5:20 下午
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        final ChickenSetFactory chickenSetFactory = new ChickenSetFactory();
        chickenSetFactory.create();
        System.out.println(chickenSetFactory);
    }

}

/**
 * 案例：肯德基 鸡肉套餐：中可+鸡肉汉堡+鸡米花（大）
 */
interface Drink {
    /**
     * 生产饮料
     *
     * @return 饮料
     */
    Drink create();
}

class Coffee implements Drink{

    /**
     * 生产饮料
     *
     * @return 饮料
     */
    @Override
    public Drink create() {
        System.out.println("咖啡");
        return new Coffee();
    }
}
class Coke implements Drink{

    /**
     * 生产饮料
     *
     * @return 饮料
     */
    @Override
    public Coke create() {
        System.out.println("可乐");
        return new Coke();
    }
}

interface StapleFood {
    /**
     * 生产主食
     *
     * @return 主食
     */
    StapleFood create();
}

class Hamburger implements StapleFood{

    /**
     * 生产主食
     *
     * @return 主食
     */
    @Override
    public StapleFood create() {
        System.out.println("汉堡");
        return new Hamburger();
    }
}

class ChickenRolls implements StapleFood{

    /**
     * 生产主食
     *
     * @return 主食
     */
    @Override
    public StapleFood create() {
        System.out.println("鸡肉卷");
        return new ChickenRolls();
    }
}

interface Snack {
    /**
     * 生产小吃
     *
     * @return 小吃
     */
    Snack create();
}

class ChickenNuggets implements Snack{

    /**
     * 生产小吃
     *
     * @return 小吃
     */
    @Override
    public Snack create() {
        System.out.println("鸡块");
        return new ChickenNuggets();
    }
}
class PopcornChicken implements Snack{

    /**
     * 生产小吃
     *
     * @return 小吃
     */
    @Override
    public Snack create() {
        System.out.println("鸡米花");
        return new PopcornChicken();
    }
}

interface SetMeal {

    void create();
}

class ChickenSetFactory implements SetMeal{
    Drink drink;

    StapleFood stapleFood;
    Snack snack;


    @Override
    public void create() {
        final Coke coke = new Coke();
        final Hamburger hamburger = new Hamburger();
        final PopcornChicken popcornChicken = new PopcornChicken();
        snack = popcornChicken.create();
        stapleFood = hamburger.create();
        drink = coke.create();
    }

    @Override
    public String toString() {
        return "ChickenSetFactory{" +
                "drink=" + drink +
                ", stapleFood=" + stapleFood +
                ", snack=" + snack +
                '}';
    }
}


