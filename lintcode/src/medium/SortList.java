package medium;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 21:18.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1-3->2->null, sort it to 1->2->3->null.
 *
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode middle = findMid(head);
        ListNode next   = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));
    }



    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (true) {
            node.next = l1.val < l2.val ? l1 : l2;
            if(l1.val < l2.val) l1 = l1.next; else l2 = l2.next;
            node = node.next;
            if(l1 == null) node.next = l2;
            if(l2 == null) node.next = l1;
            if(l1 == null || l2 == null) break;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2)))))));
        ListNode node = sortList(head);
    }
}
