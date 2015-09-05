package medium;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/2 20:53.
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * Example
 * For example,
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 *
 * 思路：找到中间节点，后半部分求倒序，前半段后半段交替插入即可
 *
 */
public class ReorderList {

    private static ListNode reverseList(ListNode head){
        if(head == null && head.next == null)
            return head;
        ListNode start = head;
        ListNode tempNode1 = head.next;
        ListNode tempNode2 = head.next;
        while (tempNode1 != null) {
            tempNode2 = tempNode2.next;
            tempNode1.next = start;
            start = tempNode1;
            tempNode1 = tempNode2;
        }
        head.next = null;
        return start;
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode doubleSpeed = head;
        ListNode halfList = head;
        while (doubleSpeed != null && doubleSpeed.next != null) {
            doubleSpeed = doubleSpeed.next.next;
            halfList = halfList.next;
        }
        halfList = reverseList(halfList);
        ListNode p1 = head;
        ListNode p2 = halfList;
        ListNode t1 = p1.next;
        ListNode t2 = p2.next;
        while(t1 != null && t2 != null){
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
            t1 = t1.next;
            t2 = t2.next;
        }
    }

}
