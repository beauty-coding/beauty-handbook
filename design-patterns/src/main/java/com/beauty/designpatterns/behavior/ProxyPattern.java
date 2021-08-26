package com.beauty.designpatterns.behavior;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description 代理模式
 *
 * @author yufengwen
 * @date 2021/8/25 1:27 下午
 */
public class ProxyPattern {


    public static void main(String[] args) {
        ciglibProxy();
    }

    private static void jdkProxy(){

        InvocationHandler handler = (proxy, method, args) -> {

            EatFood subject = new EatFood();
            System.out.println("前边干点啥");
            Object result = method.invoke(subject, args);
            System.out.println("result:"+result);
            System.out.println("后边干点啥");
            return result;
        };
        ClassLoader classLoader = EatFood.class.getClassLoader();
        Class<?>[] interfaces = EatFood.class.getInterfaces();
        EatFood o = (EatFood)Proxy.newProxyInstance(classLoader, interfaces, handler);
        o.eat();

    }

    private static void ciglibProxy(){

        MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> {

            System.out.println("前边cglib 干点啥");
            methodProxy.invokeSuper(o,objects);
            System.out.println("后边cglib 干点啥");

            return null;
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EatFood.class);
        enhancer.setCallback(methodInterceptor);


        EatFood o = (EatFood) enhancer.create();

        o.eat();
    }





}

class FoodProxy implements InvocationHandler{

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        EatFood subject = new EatFood();
        System.out.println("前边干点啥");
        Object result = method.invoke(subject, args);
        System.out.println("result:"+result);
        System.out.println("后边干点啥");
        return result;
    }
    public Object CreateProxy(){

        ClassLoader classLoader = EatFood.class.getClassLoader();
        Class<?>[] interfaces = EatFood.class.getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }
}


interface Food{
    void eat();
}

class EatFood implements Food{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}

class MeiTuan implements Food{
    private Food food = new EatFood();


    @Override
    public void eat() {

        if (food == null) {
            return;
        }
        preEatFood();
        food.eat();
        aftEatFood();
    }

    private void aftEatFood() {
        System.out.println("通知饭店做");
    }

    private void preEatFood() {
        System.out.println("骑手送餐");
    }
}
