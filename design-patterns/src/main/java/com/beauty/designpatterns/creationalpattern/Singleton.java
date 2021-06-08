package com.beauty.designpatterns.creationalpattern;

/**
 *
 */
public class Singleton {


    private Singleton(){

    }
//
//    // e han
//    private static Singleton instance = new Singleton();
//
//    public static Singleton getInstance(){
//        return instance;
//    }

//    // lan han
//    private static Singleton instance = null;
//
//    public static Singleton getInstance(){
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

//    // synchronize lan han
//    // volatile 不加 会导致 第二个线程 拿到的 instance仍然是空，还会进入方法 创建
//    private static volatile Singleton instance = null;
//
//    public static synchronized Singleton getInstance(){
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

//    // double check
//    // volatile 不加 会导致 第二个线程 拿到的 instance仍然是空，还会进入方法 创建
//    private static volatile Singleton instance = null;
//
//    public static Singleton getInstance(){
//        if (instance == null) {
//            synchronized (Singleton.class){
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }


    // 静态内部类
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }



}
