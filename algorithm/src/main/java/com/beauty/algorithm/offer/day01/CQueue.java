package com.beauty.algorithm.offer.day01;

import java.util.Stack;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/12/21 4:56 下午
 */
public class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {

        stack1.push(value);

    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2 == null||stack2.isEmpty()) {
            System.out.println(-1);
            return -1;
        }

        final Integer integer = stack2.pop();
        System.out.println(integer);
        return integer;
    }

    public static void main(String[] args) {

        final CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.appendTail(2);
        cQueue.appendTail(4);
        cQueue.deleteHead();
        cQueue.appendTail(1);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}
