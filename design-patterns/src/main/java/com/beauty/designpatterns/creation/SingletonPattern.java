package com.beauty.designpatterns.creation;

/**
 * 单例模式
 * 通过次生成的对象 全局只有一个
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 * 4、必须是私有化构造
 *
 *
 * @author yufengwen
 * @date 2021/12/9 7:24 下午
 */
public class SingletonPattern {
}

/**
 * 饿汉式
 * 线程安全
 */
class EhanSingleton{

    // 创建对象实例
    public static EhanSingleton bean = new EhanSingleton();

    /**
     * 私有构造
     */
    private EhanSingleton(){

    }

    /**
     * 提供对象的方法
     * @return 单利对象
     */
    public static EhanSingleton getBean(){
        return bean;
    }

}

/**
 * 懒汉 DCL
 * 线程安全
 */
class LHanSingleton{

    /**
     * 私有化构造
     */
    private LHanSingleton(){

    }


    private static LHanSingleton singleton;

    /**
     * 提供对象
     * @return 单例对象
     */
    public static LHanSingleton getInstance(){
        // 判断是否已经创建对象
        if (singleton == null) {
            // 解决线程安全 加锁
            // tag:1
            synchronized (LHanSingleton.class){
                // 再次判空，
                // 防止 多个线程 都到了tag:1 的位置，
                // 第一个线程创建完bean后 后续线程继续 进入不判断的话 会创建多个
                if (singleton == null) {
                    singleton = new LHanSingleton();
                }
            }
        }
        return singleton;
    }

}

/**
 * 静态内部类
 * 线程安全
 */
class InnerClassSingleton{
    /**
     * 创建 实例
     */
    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    /**
     * 私有化构造
     */
    private InnerClassSingleton(){

    }

    /**
     * 提供实例
     * @return 单例对象
     */
    public static InnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举方式
 * 线程安全 无法反序列化 获取新实例
 */
enum EnumSingleton{
    INSTANCE;

}


