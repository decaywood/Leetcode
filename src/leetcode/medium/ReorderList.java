package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class ReorderList {
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *     }
     * }
     */
    
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            this.next = null;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
    
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
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));
        reorderList(node);
    }
}
