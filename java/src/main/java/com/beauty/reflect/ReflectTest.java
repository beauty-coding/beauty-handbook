package com.beauty.reflect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/30 2:30 下午
 */
@Service
public class ReflectTest {


    public static void main(String[] args) {
        try {
//            final Class<?> peopleClass = Class.forName("com.beauty.reflect.People");
//            final Class<People> peopleClass = People.class;
//            final Class<? extends People> peopleClass = new People().getClass();
            final Class<?> peopleClass = ClassLoader.getSystemClassLoader().loadClass("com.beauty.reflect.People");
            final Class<?>[] interfaces = peopleClass.getInterfaces();
            final Constructor<?>[] constructors = peopleClass.getConstructors();
            final Constructor<?>[] declaredConstructors = peopleClass.getDeclaredConstructors();


            // 反射获取对象
            // 调用有参构造
            final Object hasValueObject = peopleClass.getDeclaredConstructor(Integer.class, String.class).newInstance(10, "小明");
            final People hasValuePeople = (People) peopleClass.getDeclaredConstructor(Integer.class, String.class).newInstance(10, "小明");
            // 无参构造
            final Object o = peopleClass.getDeclaredConstructor().newInstance();
            final People people = (People) peopleClass.getDeclaredConstructor().newInstance();



            // 获取属性
            final Field[] fields = peopleClass.getFields();
            final Field[] declaredFields = peopleClass.getDeclaredFields();
            final Field fieldName = peopleClass.getDeclaredField("name");
            fieldName.setAccessible(true);
            final String nameVal = (String) fieldName.get(o);

            // 获取方法

            final Method[] methods = peopleClass.getMethods();
            final Method[] declaredMethods = peopleClass.getDeclaredMethods();
            final Method getPMethod = peopleClass.getDeclaredMethod("pMethod", String.class);
            final Method getNameMethod = peopleClass.getDeclaredMethod("getName");
            final Method setNameMethod = peopleClass.getDeclaredMethod("setName", String.class);

            // 调用私有方法
            //在访问私有方法前设置访问操作(不设置直接调用会报错)
            getPMethod.setAccessible(true);
            getPMethod.invoke(o, "Hello");

            // 调用公有方法
            setNameMethod.invoke(o, "ketty");
            final Class<?> returnType = getNameMethod.getReturnType();
            final String invoke = String.valueOf(getNameMethod.invoke(o));
            final String name = people.getName();
            final String name1 = hasValuePeople.getName();


            // 获取 注解
            final Service peopleClassDeclaredAnnotation = peopleClass.getDeclaredAnnotation(Service.class);
            final Service peopleClassAnnotation = peopleClass.getAnnotation(Service.class);
//            final String value = peopleClassDeclaredAnnotation.value();
//            final String value1 = peopleClassAnnotation.value();

            final Annotation[] annotations = fieldName.getAnnotations();
            final Annotation[] declaredAnnotations = fieldName.getDeclaredAnnotations();

            final Class<?> xiaomingClass = Class.forName("com.beauty.reflect.Xiaoming");
            final Annotation[] xiaomingClassAnnotations = xiaomingClass.getAnnotations();
            final Annotation[] xiaomingClassDeclaredAnnotations = xiaomingClass.getDeclaredAnnotations();

            int a = 0;
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}

class Xiaoming extends People{
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

@AnnotatioDemo
class People {
    private Integer age;

    @Value("hahah")
    private String name;

    public String nickName;

     String englishName;

    public People() {
    }

    public People(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private void pMethod(String s) {
        System.out.println(s);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface AnnotatioDemo{

}