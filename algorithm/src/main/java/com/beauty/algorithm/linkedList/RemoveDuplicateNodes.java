package com.beauty.algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/3 17:11
 * @since v0.1.0.0
 */
public class RemoveDuplicateNodes {
    static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        Set<Integer> cache = new HashSet<>();

        ListNode dummy = head;



        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        ListNode listNode = removeDuplicateNodes(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
