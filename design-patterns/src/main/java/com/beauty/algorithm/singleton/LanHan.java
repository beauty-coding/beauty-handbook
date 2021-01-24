package com.beauty.algorithm.singleton;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/22 10:16
 * @since v0.1.0.0
 */
public class LanHan {


    // 类属性

    // 私有化 构造

    private LanHan(){

    }

    private static LanHan INSTANCE;

    private static LanHan getInstance(){

        if (INSTANCE == null) {
            INSTANCE = new LanHan();
        }
        return INSTANCE;
    }


}
