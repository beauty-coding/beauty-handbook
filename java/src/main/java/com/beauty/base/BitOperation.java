package com.beauty.base;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/9/29 2:57 下午
 */
public class BitOperation {

    /**  34 48
     * | 按位或      二进制 相同位 有一个1 得1  100010 | 110000 = 110010
     * & 按位与      二进制 相同位 都是1 得1  100010 & 110000 = 100000
     * ^ 异或运算符   二进制 相同位 不一样得1  100010 ^ 110000 = 010010
     * ~ 取反        二进制 所有位 0和1 互换  ~100010 = 011101
     * >> 右移       二进制数 所有位的数  往右边 移动多少位，正数左边第一位补0，负数补1，等于除以2的n次方
     * << 左移       二进制数 所有位的数  往左边 移动多少位，正数左边第一位补0，负数补1，等于乘以2的n次方
     * >>> 无符号右移     100010>>>2 = 001000(8)
     */

    public static void main(String[] args) {
        System.out.println("34|48= ");
        System.out.println(34|48);

        System.out.println("34&48= ");
        System.out.println(34&48);

        System.out.println("34^48= ");
        System.out.println(34^48);

        System.out.println("~34= ");
        System.out.println(~34);

        System.out.println("34>>2= ");
        System.out.println(34>>2);

        System.out.println("34<<2= ");
        System.out.println(34<<2);

        System.out.println("34>>>2= ");
        System.out.println(34>>>2);



        System.out.println("-34|48= ");
        System.out.println(-34|48);

        System.out.println("-34&48= ");
        System.out.println(-34&48);

        System.out.println("-34^48= ");
        System.out.println(-34^48);

        System.out.println("~-34= ");
        System.out.println(~-34);

        System.out.println("-34>>2= ");
        System.out.println(-34>>2);

        System.out.println("-34<<2= ");
        System.out.println(-34<<2);

        System.out.println("-34>>>2= ");
        System.out.println(-34>>>2);
    }
}
