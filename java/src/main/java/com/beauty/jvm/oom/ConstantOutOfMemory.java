package com.beauty.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**

 * @Described：常量池内存溢出探究
 * @vm -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=5M
 */

public class ConstantOutOfMemory {


    public static void main(String[] args) throws Exception {

       try {

           List<String> strings = new ArrayList<String>();

           int i = 111111;

           while(true){

              strings.add(String.valueOf(i++).intern());

           }

       } catch (Exception e) {

           e.printStackTrace();

           throw e;

       }

 

    }

 

}