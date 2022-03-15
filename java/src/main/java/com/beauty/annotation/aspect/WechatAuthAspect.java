package com.beauty.annotation.aspect;

import com.beauty.annotation.WechatAuth;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/30 4:19 下午
 */
@Aspect
public class WechatAuthAspect {
    // 注解声明切点，注解的全限定名
    @Pointcut("@annotation(com.beauty.annotation.WechatAuth)")
    public void annotationPointcut() {
    };

    @Before("annotationPointcut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("前事件=========================================================");
//        getAnnotation(joinPoint);
        final Signature signature = joinPoint.getSignature();
        int a = 0;
    }

    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("后事件========================================================");

    }

    @AfterReturning("annotationPointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("@AfterReturning========================================================");

    }
    @AfterThrowing("annotationPointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("@AfterThrowing========================================================");

    }
//
//    @Around("annotationPointcut()")
//    public Object process(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("@Around：执行目标方法之前...");
//        //访问目标方法的参数： 可以修改入参
//        Object[] args = point.getArgs();
//        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
//            args[0] = "修改参数";
//        }
//        Object returnValue = point.proceed(args);
//        System.out.println("@Around：执行目标方法之后...");
//        System.out.println("@Around：target：" + point.getTarget());
//        return "原返回值：" + returnValue + "，这是返回结果的后缀";
//    }
//
//    private void getAnnotation(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        //获取执行方法名
//        String methodName = method.getName();
//        WechatAuth myAnnotation = method.getAnnotation(WechatAuth.class);
//        if(null !=  myAnnotation){
//            //获取注解参数值
//            System.out.println("===========获取注解参数值==========");
//        }
//        //获取方法传递的参数
//        Object[] args = joinPoint.getArgs();
//        if(null != args){
//            System.out.println("===========获取被注解方法的 入参==========");
//            for(Object o : args){
//                System.out.println("方法传递的参数: "+ o.toString());
//            }
//        }
//        System.out.println("==============获取被注解方法的方法名"+methodName+"=============");
//    }
//


}
