package com.beauty.jvm.oom;

/**

 * @Described：栈层级不足探究
 * @vm args:-Xss512k -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/mac/yufw/yufw/workspace/beauty-handbook/java/src/main/java/com/beauty/jvm/dump
 */

public class StackOverFlow {

    private int i ;

    public void plus() {

       i++;

       plus();

    }


    public static void main(String[] args) {

       StackOverFlow stackOverFlow = new StackOverFlow();

       try {

           stackOverFlow.plus();

       } catch (Exception e) {

           System.out.println("Exception:stack length:"+stackOverFlow.i);

           e.printStackTrace();

       } catch (Error e) {

           System.out.println("Error:stack length:"+stackOverFlow.i);

           e.printStackTrace();

       }

 

    }

 

}