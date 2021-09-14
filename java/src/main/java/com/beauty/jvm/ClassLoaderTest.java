package com.beauty.jvm;

/**
 * 双亲委派 问题
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021 /1/27 19:55
 * @since v0.1.0.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        Person person = new Person();
        ClassLoader classLoader = person.getClass().getClassLoader();
        System.out.println("person,classloader:"+classLoader);
        com.beauty.jvm.Object o = new com.beauty.jvm.Object();
        ClassLoader oClassLoader = o.getClass().getClassLoader();
        System.out.println("o,classloader:"+oClassLoader);
    }


}
