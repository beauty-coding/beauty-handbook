package com.beauty.jvm;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/3/27 5:42 下午
 */
public class DeadLoop {



    void testDeadLoop(){
        while(true){
            int a = 1000;
            int b = 923;
            final int i = a % b;
            final int i1 = a * b;

            final int i2 = a / b;

        }
    }
}
