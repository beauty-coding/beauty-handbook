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

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/4 16:14
 * @since v0.1.0.0
 */
public class ReverseBetween {

    static ListNode reverseBetween(ListNode head, int m, int n) {

        // 哑铃节点
        ListNode dummy = head;

        ListNode startPre = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head;
        ListNode aft = head;

        startPre.next = head;

        int index = 0;

        while (head != null){

            if (index<m){

                startPre = startPre.next;
                pre = pre.next;
                cur = cur.next;
                aft = aft.next;

            } else if (index == m){

                pre = pre.next;
                cur = cur.next;
                aft = aft.next;

            } else if (index == n){

            }

            index++;

        }

        return dummy;

    }
}
