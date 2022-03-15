package com.beauty.base;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2022/2/27 10:15 上午
 */
public class StringDemo {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static char firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, len = s.length(); i < len; i++) {
            Character item = s.charAt(i);
            map.put(item, map.getOrDefault(item, 0) + 1);

        }
        for (int i = 0, len = s.length(); i < len; i++) {
            Character key = s.charAt(i);
            if (map.get(key) == 1) {
                return key;
            }
        }
        return ' ';

    }

}
