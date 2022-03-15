package com.beauty.designpatterns.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * description 迭代器模式
 * 迭代器（Iterator）模式的定义：提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示
 * <p>
 * 主要优点如下。
 * 访问一个聚合对象的内容而无须暴露它的内部表示。
 * 遍历任务交由迭代器完成，这简化了聚合类。
 * 它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。
 * 增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * 封装性良好，为遍历不同的聚合结构提供一个统一的接口。
 * <p>
 * 主要缺点是：增加了类的个数，这在一定程度上增加了系统的复杂性。
 * <p>
 * 迭代器模式主要包含以下角色。
 * 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
 * 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
 * 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
 * 具体迭代器（Concretelterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。
 *
 * @author yufengwen
 * @date 2021/12/21 4:14 下午
 */
public class IteratorPattern {

    public static void main(String[] args) {
        AggregateCollection aggregateCollection = new ConcreteAggregate();
        aggregateCollection.add(1);
        aggregateCollection.add(3);
        aggregateCollection.add(1);
        aggregateCollection.add(5);
        aggregateCollection.add(1);
        aggregateCollection.add(2);
        final MyIterator iterator = aggregateCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}

interface AggregateCollection {
    List<Object> lists = new ArrayList<>();

    void add(Object num);

    MyIterator iterator();
}

class ConcreteAggregate implements AggregateCollection{

    @Override
    public void add(Object num) {
        lists.add(num);
    }

    @Override
    public MyIterator iterator() {
        return new Concretelterator(lists);

    }
}



interface MyIterator {
    Boolean hasNext();

    Object next();

}

class Concretelterator implements MyIterator {
    List<Object> list = new ArrayList<>();
    Integer index = -1;

    public Concretelterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Boolean hasNext() {
        return list.size() > (index+1);
    }

    @Override
    public Object next() {

        return list.get(++index);

    }
}