package com.beauty.designpatterns.behavior;

/**
 * description
 *
 * 示例场景：
 * 去银行办理业务一般要经过以下4个流程：取号、排队、办理具体业务、对银行工作人员进行评分等，其中取号、排队和对银行工作人员进行评分的业务对每个客户是一样的，可以在父类中实现，但是办理具体业务却因人而异，它可能是存款、取款或者转账等，可以延迟到子类中实现。
 *
 * 定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤
 *
 * 该模式的主要优点如下。
 * 它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
 * 它在父类中提取了公共的部分代码，便于代码复用。
 * 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
 *
 * 该模式的主要缺点如下。
 * 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象，间接地增加了系统实现的复杂度。
 * 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
 * 由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。
 *
 * 模板方法模式包含以下主要角色。
 * 1）抽象类/抽象模板（Abstract Class）
 * 抽象模板类，负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。这些方法的定义如下。
 *
 * ① 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。
 *
 * ② 基本方法：是整个算法中的一个步骤，包含以下几种类型。
 * 抽象方法：在抽象类中声明，由具体子类实现。
 * 具体方法：在抽象类中已经实现，在具体子类中可以继承或重写它。
 * 钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。
 * 2）具体子类/具体实现（Concrete Class）
 * 具体实现类，实现抽象类中所定义的抽象方法和钩子方法，它们是一个顶级逻辑的一个组成步骤。
 *
 * @author yufengwen
 * @date 2021/12/15 8:05 下午
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractBankBusinessTemplateMethod templateMethod = new ConcreteBody();
        templateMethod.doWork();
    }
}

//取号、排队、办理具体业务、对银行工作人员进行评分
abstract class AbstractBankBusinessTemplateMethod{

    private void getNo(){
        System.out.println("取号");
    }
    private void lineUp(){
        System.out.println("排队");
    }

    abstract void deal();

    private void evaluate(){
        System.out.println("评价");
    }

    public void doWork(){
        getNo();
        lineUp();
        deal();
        evaluate();
    }

}

class ConcreteBody extends AbstractBankBusinessTemplateMethod{

    @Override
    public void deal() {
        System.out.println("取款");
    }
}
