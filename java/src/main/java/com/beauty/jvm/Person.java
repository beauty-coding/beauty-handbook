package com.beauty.jvm;

public class Person {
    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    static {
        int a = 10;
        int b = 11;
    }

    public static void main(String[] args) {

        int a = 100;
        System.out.println(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}