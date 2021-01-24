package com.beauty.algorithm.singleton;

/**
 * 匿名内部类
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/22 10:41
 * @since v0.1.0.0
 */
public class Cryptonym {

    private Cryptonym(){

    }

    private static class Holder{

        private static final Cryptonym INSTANCE = new Cryptonym();

    }

    private static Cryptonym getInstance(){
        return Holder.INSTANCE;
    }
}
