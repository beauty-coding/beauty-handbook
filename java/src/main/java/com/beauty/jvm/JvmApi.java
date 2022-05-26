package com.beauty.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/3/27 5:39 下午
 */
@RestController
@RequestMapping("/jvm")
public class JvmApi {

    @GetMapping("/deadLock")
    void testDeadLock() {
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


    @GetMapping("/deadLoop")
    void testDeadLoop() {
        while (true) {
            int a = 1000;
            int b = 923;
            final int i = a % b;
            final int i1 = a * b;

            final int i2 = a / b;

        }
    }

}
