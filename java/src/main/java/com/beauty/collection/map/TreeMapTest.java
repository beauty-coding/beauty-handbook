package com.beauty.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/9/13 5:27 下午
 */
public class TreeMapTest {

    public static void main(String[] args) {
        final TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> {
            if (o1>o2) {
                return -1;
            }
            if (o1.equals(o2)) {
                return 0;
            }
            return 1;
        });
        treeMap.put(10,10);
        treeMap.put(9,9);
        treeMap.put(1,1);
        treeMap.put(7,7);
        treeMap.put(8,8);
        treeMap.put(6,6);
        treeMap.put(2,2);
        treeMap.put(4,4);
        treeMap.put(3,3);
        treeMap.put(5,5);
        treeMap.forEach((key,value)->{
            System.out.println("key:"+key+"value:"+value);
        });

        final Comparator<? super Integer> comparator = treeMap.comparator();
    }
}
