package com.beauty.thread;

import org.junit.Test;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/21 9:52
 * @since v0.1.0.0
 */
public class ThreadLocalTest {


    public static void main(String[] args) {

        InheritableThreadLocal<Integer> local = new  InheritableThreadLocal<Integer>();
        local.set(1);

        new Thread(()->{
            //业务代码
            System.out.println("lambda方式创建线程-》"+Thread.currentThread().getName());
            System.out.println(local.get());
        }).start();

        System.out.println(local.get());

    }




}
