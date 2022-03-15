package com.beauty.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] maxArr = new int[nums.length-k+1];

        Map<Integer,Integer> maxCache = new HashMap<>(4);

        for(int i = 0; i + k <= nums.length; i++){

            int curMax = Integer.MIN_VALUE;
            if(i==0){
                for(int j = 0;j<k;j++){
                    if(curMax < nums[j]){
                        curMax = nums[j];
                        maxCache.clear();
                        maxCache.put(curMax,j);
                    }
                }
                if(maxCache.isEmpty()){
                    maxCache.put(curMax,k-1);
                }
                maxArr[i] = curMax;
                continue;
            }
            int index = maxCache.get(maxArr[i-1]);
            if(nums[i+k-1]>maxArr[i-1]){
                curMax = nums[i+k-1];
            }else if(index >= i){
                curMax = maxArr[i-1];
            } else {
                for(int j = i;j<k+i;j++){
                    if(curMax < nums[j]){
                        curMax = nums[j];
                        maxCache.clear();
                        maxCache.put(curMax,j);
                    }
                }
            }

            maxArr[i] = curMax;

        }

        return maxArr;

    }
}
