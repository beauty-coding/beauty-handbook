package com.beauty.collection.map;


import java.util.concurrent.ConcurrentHashMap;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/20 12:35
 * @since v0.1.0.0
 */
public class CurrentHashMapTest {

    public void test(){
        final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
        concurrentHashMap.put("1","1");
    }



}
