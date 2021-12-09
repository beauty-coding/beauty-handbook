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
        final ShallowCloneInstance clone = instance.clone();
        System.out.println("instance:"+instance);
        System.out.println("clone:"+clone);
    }

}

/**
 * 浅克隆
 */
class ShallowCloneInstance implements Cloneable{

    private String item;

    public ShallowCloneInstance() {

    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public ShallowCloneInstance clone() {
        try {
            return (ShallowCloneInstance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "ShallowClonceInstance{" +
                "item='" + item + '\'' +
                '}';
    }
}

class DeepCloneInstance{

}