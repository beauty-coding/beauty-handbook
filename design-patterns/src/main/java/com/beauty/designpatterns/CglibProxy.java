package com.beauty.designpatterns;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/12/6 3:00 下午
 */
public class CglibProxy {

    public static void main(String[] args) {
        final CgProxy<Xm> callback = new CgProxy<>();
        final Xm proxy = callback.getProxy(Xm.class);
        proxy.eat();
    }

}

class CgProxy<T> implements MethodInterceptor{

    public T getProxy(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(clazz);
        //设置方法拦截处理器
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 代理");
        System.out.println(method.getName());
        System.out.println(methodProxy.getSuperName());
        methodProxy.invokeSuper(o,objects);

        return null;
    }
}



