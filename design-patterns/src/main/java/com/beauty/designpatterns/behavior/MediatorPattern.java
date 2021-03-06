package com.beauty.designpatterns.behavior;

import java.util.List;

/**
 * description 中介者模式
 * 中介者（Mediator）模式的定义：定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 *
 * 中介者模式是一种对象行为型模式，其主要优点如下。
 * 类之间各司其职，符合迪米特法则。
 * 降低了对象之间的耦合性，使得对象易于独立地被复用。
 * 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 *
 * 其主要缺点是：中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越臃肿，变得复杂且难以维护。
 *
 *  模式的结构
 * 中介者模式包含以下主要角色。
 * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 具体中介者（Concrete Mediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 *
 * 场景：外卖平台
 * 中介者：外卖平台
 * 具体中介：具体的外卖平台 饿了吗/美团
 * 具体使用者：骑手、订餐客户、商家
 *
 * @author yufengwen
 * @date 2021/12/21 2:39 下午
 */
public class MediatorPattern {

    public static void main(String[] args) {
        final Mediator meituan = new Meituan();

    }

}

interface Mediator{


    /**
     * 通知
     */
    void notifyColleague(Colleague colleague);
}

class Meituan implements Mediator{

    /**
     * 通知
     */
    @Override
    public void notifyColleague(Colleague colleague) {

        System.out.println("平台通知了");
    }
}

interface Colleague{

    void doWork(Mediator mediator);
}

/**
 * 订餐人
 */
class People implements Colleague{

    @Override
    public void doWork(Mediator mediator) {
        mediator.notifyColleague(this);
        System.out.println("订餐，送到后吃饭");
    }
}

/**
 * 骑手
 */
class Driver implements Colleague{

    @Override
    public void doWork(Mediator mediator) {
        mediator.notifyColleague(this);
        System.out.println("收到订单，取货送餐");
    }
}


/**
 * 餐厅
 */
class Restaurant implements Colleague{

    @Override
    public void doWork(Mediator mediator) {
        mediator.notifyColleague(this);
        System.out.println("收到订单，做餐");
    }
}