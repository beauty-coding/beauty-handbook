package com.beauty.singleton;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/22 10:35
 * @since v0.1.0.0
 */
public class DoubleCheck {

    private static DoubleCheck instance;

    private DoubleCheck(){

    }

    private static DoubleCheck getInstance(){
        if (instance == null) {
            synchronized (DoubleCheck.class){
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

}
