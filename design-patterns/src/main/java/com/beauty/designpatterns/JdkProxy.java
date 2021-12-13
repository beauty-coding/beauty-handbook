package com.beauty.designpatterns;

import java.lang.reflect.Proxy;

/**
 * description
 * 主体方法 Proxy.newProxyInstance（ClassLoader loader,
 *                                           Class<?>[] interfaces,
 *                                           InvocationHandler h）
 *                                           InvocationHandler的实现为 代理的实现
 *
 * @author yufengwen
 * @date 2021/12/6 2:34 下午
 */
public class JdkProxy  {

    public static void main(String[] args) {

        Class<Person> personClass = Person.class;

        final Person o = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, (proxy, method, args1) -> {
            System.out.println("走了代理");
            System.out.println(method.getName());
            method.invoke(personClass.getConstructor().newInstance(), args1);
            return null;
        });
        o.eat();
    }
}

class Xm implements Person{

    @Override
    public void eat() {

    }

    @Override
    public void say() {

    }
}

interface Person{

    void eat();

    void say();
}
