package com.beauty.algorithm.offer.day01;

import org.junit.Test;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/1/23 3:05 下午
 */
public class Divide {

    @Test
    public void test() {
        divide(-2147483648, -1);
    }

    public int divide(int a, int b) {

        // 边缘判断
        if (a == 0 || b == 1) {
            return a;
        }
        if (b == -1) {
            a = -a;
            return dealResult(a);
        }

        Boolean hasPositive = false;
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            hasPositive = true;
        }
        // 都取正
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;

        int sum = 0;
        int i = -1;

        while (i < a && sum <= a) {
            sum += b;
            i++;
        }
        int orgResult = hasPositive ? i : -i;

        return dealResult(orgResult);


    }

    private int dealResult(int param) {
        if (param >= (-2147483648) && param <= 2147483647) {
            return param;
        }
        return 2147483647;
    }
}
