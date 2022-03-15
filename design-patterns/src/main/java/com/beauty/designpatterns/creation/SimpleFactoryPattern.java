package com.beauty.designpatterns.creation;

/**
 * description 简单工厂模式
 *
 * 简单工厂模式中创建实例的方法通常为静态（static）方法，因此简单工厂模式（Simple Factory Pattern）又叫作静态工厂方法模式（Static Factory Method Pattern）
 *
 * 优点：
 * 工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。
 * 客户端无需知道所创建具体产品的类名，只需知道参数即可。
 * 也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。
 * 缺点：
 * 简单工厂模式的工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。
 * 使用简单工厂模式会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度
 * 系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂
 * 简单工厂模式使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。
 *
 * 简单工厂模式的主要角色如下：
 * 简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
 * 抽象产品（Product）：是简单工厂创建的所有对象的父类，负责描述所有实例共有的公共接口。
 * 具体产品（ConcreteProduct）：是简单工厂模式的创建目标。
 *
 * @author yufengwen
 * @date 2021/12/10 4:09 下午
 */
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        final Product productA = SimpleFactory.creatProduct(1);
        productA.getProduct();
        final Product productB = SimpleFactory.creatProduct(2);
        productB.getProduct();
    }

    public interface Product{

        void getProduct();
    }

    static class ConcreteProductA implements Product{

        @Override
        public void getProduct() {
            System.out.println("对象A");
        }
    }
    static class ConcreteProductB implements Product{

        @Override
        public void getProduct() {
            System.out.println("对象B");
        }
    }

   static class SimpleFactory{

        public static final int SCENE_A = 1;
        public static final int SCENE_B = 2;
        public static final int SCENE_C = 3;

        public static Product creatProduct(int scene){
            switch (scene){
                case SCENE_A:
                    return new ConcreteProductA();
                case SCENE_B:
                    return new ConcreteProductB();
                default:
                    return new ConcreteProductA();
            }
        }
    }

}





