package com.beauty.algorithm.linkedList;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/3 17:11
 * @since v0.1.0.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
