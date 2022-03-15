package com.beauty.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * @vm  -Xms5M -Xmn5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/mac/yufw/yufw/workspace/beauty-handbook/java/src/main/java/com/beauty/jvm/dump
 * # 或者指定文件名
 * -XX:HeapDumpPath=/data/dump/1.hprof
 * @author yufengwen
 * @date 2021/10/30 11:55 上午
 */
public class HeapOOM {

    public static void main(String[] args) {
        Byte[] cases = new Byte[1024];

        List<Byte[]> caseList = new ArrayList<>();

        while(true){

            caseList.add(cases);

        }

    }

}

