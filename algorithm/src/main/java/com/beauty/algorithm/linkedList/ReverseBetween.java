package com.beauty.algorithm.linkedList;
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 592 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.List;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/4 16:14
 * @since v0.1.0.0
 */
public class ReverseBetween {
//
//    static ListNode reverseBetween(ListNode head, int m, int n) {
//
//        // 哑铃节点
//        ListNode dummy = head;
//
//        ListNode startPre = new ListNode(0);
//        ListNode pre = head;
//        ListNode cur = head;
//        ListNode aft = head;
//
//        startPre.next = head;
//
//        int index = 0;
//
//        while (head != null){
//
//            if (index<m){
//
//                startPre = startPre.next;
//                pre = pre.next;
//                cur = cur.next;
//                aft = aft.next;
//
//            } else if (index == m){
//
//                pre = pre.next;
//                cur = cur.next;
//                aft = aft.next;
//
//            } else if (index == n){
//
//            }
//
//            index++;
//
//        }
//
//        return dummy;
//
//    }

    public static void main(String[] args) {

    }

    static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode aft = null;

        for (int i = 0; i < right - left; i++) {
            aft = cur.next;
            cur.next = aft.next;
            aft.next = pre.next;
            pre.next = aft;
        }

        return dummyNode.next;


    }


}
