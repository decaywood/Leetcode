package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 12:34.
 *
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 *
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode greaterEqual = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode smallerTail = partition(head, greaterEqual, smaller, x);
        smallerTail.next = greaterEqual.next;
        return smaller.next;
    }

    public static ListNode partition(ListNode head, ListNode greaterEqual, ListNode smaller, int x) {
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greaterEqual.next = head;
                greaterEqual = greaterEqual.next;
            }
            head = head.next;
        }
        greaterEqual.next = null;
        return smaller;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        partition(head, 3);
    }
}
