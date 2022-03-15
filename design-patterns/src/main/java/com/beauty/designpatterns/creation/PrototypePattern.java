package com.beauty.designpatterns.creation;

/**
 * 原型模式的克隆分为浅克隆和深克隆。
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 *
 * 原型模式包含以下主要角色。
 * 抽象原型类：规定了具体原型对象必须实现的接口。
 * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 *
 * Shallow clone
 * @author yufw
 *
 */
public class PrototypePattern {

    public static void main(String[] args) {
        final ShallowCloneInstance instance = new ShallowCloneInstance();
        instance.setItem("ShallowCloneInstance");
        instance.setPerson(new Person());
        final ShallowCloneInstance clone = instance.clone();
        System.out.println(instance);
        System.out.println(clone);
        System.out.println(instance.getItem());
        System.out.println(instance.getPerson());
        System.out.println(clone.getItem());
        System.out.println(clone.getPerson());
    }

}

/**
 * 浅克隆
 */
class ShallowCloneInstance implements Cloneable{

    private int age;
    private String item;
    private Person person;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getItem() {
        return item;
    }

    public Person getPerson() {
        return person;
    }

    public ShallowCloneInstance() {

    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public ShallowCloneInstance clone() {
        try {
            return (ShallowCloneInstance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}

class DeepCloneInstance implements Cloneable{


    private int age;
    private String item;
    private Person person;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public DeepCloneInstance() {

    }


    @Override
    public DeepCloneInstance clone() {
        try {
            DeepCloneInstance clone = (DeepCloneInstance) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


class Person implements Cloneable{

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}