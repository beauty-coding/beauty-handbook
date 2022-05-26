package com.beauty.jvm;


import java.util.Date;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/3/27 5:25 下午
 */
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(new Date().toString() + " LockA 开始执行");
                    synchronized (DeadLock.obj1) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj1");
                        Thread.sleep(3000); // 此处等待是给B能锁住机会
                        synchronized (DeadLock.obj2) {
                            System.out.println(new Date().toString() + " LockA 锁住 obj2");
                            Thread.sleep(6000); // 为测试，占用了就不放
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(new Date().toString() + " LockB 开始执行");
                    synchronized (DeadLock.obj2) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj2");
                        Thread.sleep(3000); // 此处等待是给A能锁住机会
                        synchronized (DeadLock.obj1) {
                            System.out.println(new Date().toString() + " LockB 锁住 obj1");
                            Thread.sleep(6000); // 为测试，占用了就不放
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}



