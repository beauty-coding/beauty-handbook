package com.beauty.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @deprecated ：方法区溢出测试
 * @vm  -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */

public class MethodAreaOutOfMemory {



    public static void main(String[] args) {

       while(true){

           Enhancer enhancer = new Enhancer();

           enhancer.setSuperclass(TestCase.class);

           enhancer.setUseCache(false);

           enhancer.setCallback((MethodInterceptor) (arg0, arg1, arg2, arg3) -> arg3.invokeSuper(arg0, arg2));

           enhancer.create();

       }

    }

}

class TestCase{



}