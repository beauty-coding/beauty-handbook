package com.beauty;

/**
 * 爬楼梯
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/21 14:26
 * @since v0.1.0.0
 */
public class ClimbStairs {

    /**
     * 动态规划
     * @param n 台阶数
     * @return
     */
    public int climbStairs(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int dp1 = 1;
        int dp2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = dp2;
            dp2 = dp1+dp2;
            dp1 = temp;
        }
        return dp1+dp2;

    }
}
