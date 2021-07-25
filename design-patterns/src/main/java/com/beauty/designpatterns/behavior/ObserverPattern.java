package com.beauty.designpatterns.behavior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 观察者模式
 *
 * @author yufw
 */
public class ObserverPattern {

    public static void main(String[] args) {
//        ObserverA observerA = new ObserverA();
//        ObserverB observerB = new ObserverB();
//        Subject subject = new SubjectA();
//        subject.add(observerA);
//        subject.add(observerB);
//        subject.notifyObserver();
        Reader readerA = new ReaderA();
        Reader readerB = new ReaderB();
        Blogger blogger = new Ming();
        blogger.addReader(readerA);
        blogger.addReader(readerB);
        blogger.write();

    }
}

/**
 * 抽象目标类
 */
abstract class Subject {

    Set<Observer> observerList = new HashSet<>();

    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知观察者
     */
    public abstract void notifyObserver();

}

/**
 * 目标
 */
class SubjectA extends Subject {

    /**
     * 通知观察者
     */
    @Override
    public void notifyObserver() {

        super.observerList.forEach(Observer::response);
    }
}

/**
 * 抽象观察者（接口）
 */
interface Observer {

    /**
     * 观察者回复方法
     */
    void response();

}

/**
 * 观察者A
 */
class ObserverA implements Observer {

    /**
     * 观察者回复方法
     */
    @Override
    public void response() {
        System.out.println("ObserverA response");
    }
}

/**
 * 观察者B
 */
class ObserverB implements Observer {

    /**
     * 观察者回复方法
     */
    @Override
    public void response() {
        System.out.println("ObserverB response");
    }
}

//========================实例=========================================
/**
 * 读者 订阅 博主
 * 博主发新文章，推送给 读者
 */

abstract class Blogger{

    List<Reader> readerList = new ArrayList<>();

    void addReader(Reader reader){
        System.out.println(reader.toString()+"订阅了博主");
        readerList.add(reader);
    }

    void removeReader(Reader reader){
        System.out.println(reader.toString()+"退订了博主");
        readerList.remove(reader);
    }

    /**
     * 写文章
     */
    abstract void write();

}

class Ming extends Blogger{

    /**
     * 写文章
     */
    @Override
    void write() {
        System.out.println("写了新文章");
        readerList.forEach(Reader::read);
    }
}

interface Reader{

    void read();

}
class ReaderA implements Reader{

    @Override
    public void read() {
        System.out.println("ReaderA 收到了博主的新文章");
    }
}
class ReaderB implements Reader{

    @Override
    public void read() {
        System.out.println("ReaderB 收到了博主的新文章");
    }
}
