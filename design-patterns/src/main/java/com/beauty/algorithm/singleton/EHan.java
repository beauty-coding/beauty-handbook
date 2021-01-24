package com.beauty.algorithm.singleton;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/22 10:16
 * @since v0.1.0.0
 */
public class EHan {


    // 类属性

    // 私有化 构造

    private EHan(){

    }

    private static final EHan instance = new EHan();

    private static EHan eHan(){

        return instance;
    }


}
