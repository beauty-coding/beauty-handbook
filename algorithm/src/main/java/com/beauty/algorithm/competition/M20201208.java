package com.beauty.algorithm.competition;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟1
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/8 10:46
 * @since v0.1.0.0
 */
public class M20201208 {

    public static int titleToNumber(String s) {

        Map<Character,Integer> dic = new HashMap<>();
        dic.put('A',1);
        dic.put('B',2);
        dic.put('C',3);
        dic.put('D',4);
        dic.put('E',5);
        dic.put('F',6);
        dic.put('G',7);
        dic.put('H',8);
        dic.put('I',9);
        dic.put('J',10);
        dic.put('K',11);
        dic.put('L',12);
        dic.put('M',13);
        dic.put('N',14);
        dic.put('O',15);
        dic.put('P',16);
        dic.put('Q',17);
        dic.put('R',18);
        dic.put('S',19);
        dic.put('T',20);
        dic.put('U',21);
        dic.put('V',22);
        dic.put('W',23);
        dic.put('X',24);
        dic.put('Y',25);
        dic.put('Z',26);

        if ("".equals(s) || s == null) {
            return 0;
        }

        final char[] chars = s.toCharArray();

        int sum = 0;


        for (int len=chars.length,i = len-1; i >=0; i--) {

            final char item = chars[i];

            sum += Math.pow(26,(len - 1 - i)) * dic.get(item);

        }

        return sum;
    }

    public static int findSpecialInteger(int[] arr) {

        // 边缘判断
        final int length = arr.length;
        if (length <4){
            return arr[0];
        }

        final float v = length * 0.25f;

        Map<Integer, Integer> cache = new HashMap<>();


        for (final int item : arr) {

            Integer nums = cache.get(item);
            if (nums != null) {
                nums++;
                if (nums > v) {
                    return item;
                }
                cache.put(item,nums);
                continue;
            }
            cache.put(item, 1);

        }

        return 0;

    }

    public static int flipLights(int n, int m) {

        final int step = m % 3;

        if (n==1){
            return 2;
        }
        if (n<3){
            return 3;
        }
        if (step==1){
            return 4;
        }
        return 7;

    }
}
