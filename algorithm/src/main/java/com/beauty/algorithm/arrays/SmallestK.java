package com.beauty.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/4 12:43
 * @since v0.1.0.0
 */
public class SmallestK {
    public static int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = arr.length; i < len; i++) {
            if (i < 4) {
                result.add(arr[i]);
            } else {
                final Integer integer = result.stream().max(Integer::compareTo).get();
                if (integer > arr[i]) {
                    result.remove(integer);
                    result.add(arr[i]);
                    break;
                }

            }

        }
        int[] resultInt = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i] = result.get(i);
        }

        return resultInt;

    }


    public static void main(String[] args) {
        int[] integers = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        final int[] ints = smallestK(integers, 3);

        System.out.println(ints);
    }
}
