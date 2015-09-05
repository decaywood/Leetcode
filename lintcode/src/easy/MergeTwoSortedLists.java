package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 11:43.
 *
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 *
 * Example
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 *
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        mergeTwoLists(head, l1, l2);
        return head.next;
    }

    public static void mergeTwoLists(ListNode head, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            head.next = l1 == null ? l2 : l1;
            return;
        }
        head.next = l1.val < l2.val ? l1 : l2;
        if(l1.val < l2.val) mergeTwoLists(head.next, l1.next, l2); else mergeTwoLists(head.next, l1, l2.next);
    }

}
