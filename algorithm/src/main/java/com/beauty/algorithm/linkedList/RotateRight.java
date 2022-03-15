package com.beauty.algorithm.linkedList;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/3 20:49
 * @since v0.1.0.0
 */
public class RotateRight {
    static ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode headLen = head;
        while(headLen != null){
            len++;
            headLen = headLen.next;
        }

        //  确定 移动步数
        int step = k%len;
        if (step == 0){
            return head;
        }

        // 双指针
        ListNode pre = head;



        ListNode aft = head;
        ListNode dummy = pre.next;

        for(int i = 0;i<step;i++){

            aft = aft.next;
        }

        while(aft.next != null){
            pre = pre.next;
            dummy = dummy.next;
            aft = aft.next;

        }

        pre.next = null;
        aft.next = head;

        return dummy;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode listNode = rotateRight(head, 4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
